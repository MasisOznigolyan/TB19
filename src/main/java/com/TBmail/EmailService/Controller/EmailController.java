package com.TBmail.EmailService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TBmail.EmailService.Collections.Email;
import com.TBmail.EmailService.Response.EmailResponse;
import com.TBmail.EmailService.Service.EmailService;

@RestController
public class EmailController {

	@Autowired
	EmailService emailService;
	
	@PostMapping("/emails/create")
	public ResponseEntity<EmailResponse> createEmail(@RequestBody Email email){
		EmailResponse eMail=emailService.createNewEmail(email);
		return ResponseEntity.status(HttpStatus.CREATED).body(eMail);
		
	}
	@DeleteMapping("/emails/delete")
	public ResponseEntity<Void> deleteAllEmails(){
		emailService.deleteAllEmails();
		return ResponseEntity.status(HttpStatus.GONE).build();
	}
}
