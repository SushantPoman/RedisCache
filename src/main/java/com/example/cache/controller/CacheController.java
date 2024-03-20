package com.example.cache.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.cache.model.User;
import com.example.cache.repository.CacheRepository;

@RestController
public class CacheController {

	@Autowired
	CacheRepository repository;
	
	@GetMapping("/list")
	@Cacheable(value="users")
	public List<User> getAllUsers(){
		List<User> users = repository.findAll();
		return users;
	}
	
	@GetMapping("/list/{id}")
	@Cacheable(value="user", key = "#id")
	public User getUserById(@PathVariable Integer id){
		User user = repository.findByUid(id);
		return user;
	}
	
}
