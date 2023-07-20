package com.TBmail.EmailService.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.TBmail.EmailService.Collections.LastSent;
import com.TBmail.EmailService.Response.LastSentResponse;


public interface LastSentRepository extends MongoRepository<LastSent, String> {
    List<LastSent> findAll();
    LastSent findByLastSentId(String lastSentId);
    @SuppressWarnings("unchecked")
    LastSent save(LastSentResponse lastSentUrl);
    void deleteById(String id);
    void deleteAll();
    //LastSent findByeMailId(String EmailId);
    LastSent findByUserEmailId(String userEmailId);
	
  
}