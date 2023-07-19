package com.TBmail.EmailService.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.TBmail.EmailService.Collections.UserEmail;
public interface UserEmailRepository extends MongoRepository<UserEmail,String> {

	@SuppressWarnings("unchecked")
    UserEmail save(UserEmail userEmail);
    UserEmail findByUserId(String userId);
    UserEmail findByEmailId(String EmailId);
    List<UserEmail> findAll();
    void deleteById(String id);
    void deleteAll();
}
