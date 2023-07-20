package com.TBmail.EmailService.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TBmail.EmailService.Collections.Email;
import com.TBmail.EmailService.Repositories.EmailRepository;
import com.TBmail.EmailService.Response.EmailResponse;

@Service
public class EmailService {
	@Autowired
	private EmailRepository emailRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public void deleteAllEmails() {
		emailRepository.deleteAll();
	}
	
	
	public EmailResponse createNewEmail(Email email) {
		Email eMail=emailRepository.save(email);
		return modelMapper.map(eMail, EmailResponse.class);
	}
	
    public EmailResponse findById(String id) {
        Optional<Email> optionalEmail = emailRepository.findById(id);
        Email email = optionalEmail.orElseThrow(NoSuchElementException::new);

        return modelMapper.map(email, EmailResponse.class);
    }
    
	
	public EmailResponse findByEmailId(String id) {
		Email eMail=emailRepository.findByEMailId(id);
		return modelMapper.map(eMail, EmailResponse.class);
	}
}
