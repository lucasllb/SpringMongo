package com.lucasBittencourt.springMongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lucasBittencourt.springMongo.domain.Post;
import com.lucasBittencourt.springMongo.services.PostService;

@RestController
@RequestMapping(value="/posts")
@ComponentScan(basePackages = "com.lucasBittencourt.springMongo")
public class PostResource {
	
	@Autowired
	private PostService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String oi(){
		return "oi";
	}
}
