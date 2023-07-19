package com.TBmail.EmailService.Repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.TBmail.EmailService.Collections.User;

public interface UsersRepository extends MongoRepository<User, String> {
	Optional<User> findByUserId(String uid);
	//Optional<User> findByEMail(String EMail);
}
