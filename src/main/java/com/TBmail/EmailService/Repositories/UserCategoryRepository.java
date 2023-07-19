package com.TBmail.EmailService.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.TBmail.EmailService.Collections.UserCategory;

public interface UserCategoryRepository extends MongoRepository<UserCategory,String> {
	UserCategory findByUserCategoryId(String UserCategoryId);
    List<UserCategory> findAll();
    @SuppressWarnings("unchecked")
    UserCategory save(UserCategory userCategory);
    void deleteById(String id);
    void deleteAll();
    UserCategory findByUserId(String userId);
	
}