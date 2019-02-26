package com.lucasBittencourt.springMongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.lucasBittencourt.springMongo.domain.Post;
import com.lucasBittencourt.springMongo.domain.User;
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
		
		Post post1 = new Post(null, sdf.parse("21/01/2019"), "Partiu", "Viajarrrrrrrrrrr", maria);
		Post post2 = new Post(null, sdf.parse("22/01/2019"), "Partiu 2 ", "Viajarrrrrrrrrrr 2", maria);
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob)); 
		postRepository.saveAll(Arrays.asList(post1, post2)); 
	}

}
