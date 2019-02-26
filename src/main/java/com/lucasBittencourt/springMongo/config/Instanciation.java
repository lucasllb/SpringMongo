package com.lucasBittencourt.springMongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.lucasBittencourt.springMongo.domain.Post;
import com.lucasBittencourt.springMongo.domain.User;
import com.lucasBittencourt.springMongo.dto.AuthoDTO;
import com.lucasBittencourt.springMongo.dto.CommetDTO;
import com.lucasBittencourt.springMongo.repository.PostRepository;
import com.lucasBittencourt.springMongo.repository.UserRepository;

@Configuration
public class Instanciation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com"); 
		User alex = new User(null, "Alex Green", "alex@gmail.com"); 
		User bob = new User(null, "Bob Grey", "bob@gmail.com"); 
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/01/2019"), "Partiu", "Viajarrrrrrrrrrr", new AuthoDTO(maria));
		Post post2 = new Post(null, sdf.parse("22/01/2019"), "Partiu 2 ", "Viajarrrrrrrrrrr 2", new AuthoDTO(maria));
		
		CommetDTO c1 = new CommetDTO("ohh", sdf.parse("21/01/2019"), new AuthoDTO(alex));
		CommetDTO c2 = new CommetDTO("ehh", sdf.parse("21/01/2019"), new AuthoDTO(bob));
		
		post1.getComments().addAll(Arrays.asList(c1));
		post2.getComments().addAll(Arrays.asList(c2));
		 
		postRepository.saveAll(Arrays.asList(post1, post2)); 
		
		maria.getPosts().addAll(Arrays.asList(post1,post2));
		userRepository.save(maria);
	}

}
