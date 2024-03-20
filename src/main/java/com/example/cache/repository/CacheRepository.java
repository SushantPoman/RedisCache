package com.example.cache.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cache.model.User;


public interface CacheRepository extends JpaRepository<User, Integer> {

	User findByUid(int i);

}
