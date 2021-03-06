package com.lucasBittencourt.springMongo.repository;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lucasBittencourt.springMongo.domain.User;

@Repository
@ComponentScan(basePackages = "com.lucasBittencourt.springMongo")
public interface UserRepository extends MongoRepository<User, String>{

}
