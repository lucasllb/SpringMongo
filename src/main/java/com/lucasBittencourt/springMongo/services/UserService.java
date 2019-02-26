package com.lucasBittencourt.springMongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.lucasBittencourt.springMongo.domain.User;
import com.lucasBittencourt.springMongo.repository.UserRepository;

@Service
@ComponentScan(basePackages = "com.lucasBittencourt.springMongo")
public class UserService {
	
	@Autowired
	private UserRepository repo;

	public List<User> findAll(){
		return repo.findAll();
	}
	
}
