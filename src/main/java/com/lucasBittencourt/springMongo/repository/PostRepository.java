package com.lucasBittencourt.springMongo.repository;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lucasBittencourt.springMongo.domain.Post;

@Repository
@ComponentScan(basePackages = "com.lucasBittencourt.springMongo")
public interface PostRepository extends MongoRepository<Post, String>{

	List<Post> findByTitleContainingIgnoreCase(String text);
	
}
