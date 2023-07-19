package com.TBmail.EmailService.Repositories;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.TBmail.EmailService.Collections.Email;
@Repository 
public interface EmailRepository extends MongoRepository<Email, String> {
    Email findByEMailId(String emailId);
    List<Email> findAll();
    @SuppressWarnings("unchecked")
	Email save(Email email);
    void deleteById(String id);
    void deleteAll();
    List<Email> findByEMail(String name);
    
}
