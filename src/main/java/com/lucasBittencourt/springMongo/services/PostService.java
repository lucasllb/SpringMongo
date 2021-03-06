package com.lucasBittencourt.springMongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.lucasBittencourt.springMongo.domain.Post;
import com.lucasBittencourt.springMongo.repository.PostRepository;
import com.lucasBittencourt.springMongo.services.exception.ObjectNotFoundExcption;

@Service
@ComponentScan(basePackages = "com.lucasBittencourt.springMongo")
public class PostService {
	
	@Autowired
	private PostRepository repo;

	public Post findById(String id) {  
		Optional<Post> obj = repo.findById(id);  
		return obj.orElseThrow(() -> new ObjectNotFoundExcption("Objeto não encontrado"));
	} 
	
	public List<Post> findByTitle(String text){
		return repo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullSearch(text, minDate, maxDate);
	}
	
}
