package com.codingdojo.LoginAndRegistration.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.LoginAndRegistration.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
 
	//FIND USER BY (MATCHING) EMAIL
	Optional<User> findByEmail(String email);
 
}
