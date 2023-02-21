package com.codingdojo.plantify.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.plantify.models.User;

public interface UserRepository extends CrudRepository<User, Long>{
	public Optional<User> findByUsername(String username);
}
