package com.TBmail.EmailService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TBmail.EmailService.Collections.Email;
import com.TBmail.EmailService.Response.EmailResponse;
import com.TBmail.EmailService.Service.EmailService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name="Email", description="Controller for Email CRUD operations")
public class EmailController {

	@Autowired
	EmailService emailService;
	
	@Operation(summary="create/update E-mail",
			description="create/update by spesifying Email object. Response will be EmailResponse object")
	@PostMapping("/emails/create")
	public ResponseEntity<EmailResponse> createEmail(@RequestBody Email email){
		EmailResponse eMail=emailService.createNewEmail(email);
		return ResponseEntity.status(HttpStatus.CREATED).body(eMail);
		
	}
	
	
	@Operation(summary="delete all the Emails",
			description="deletes all the Emails from the database. Do not use if if you don't have database backup")
	@DeleteMapping("/emails/delete")
	public ResponseEntity<Void> deleteAllEmails(){
		emailService.deleteAllEmails();
		return ResponseEntity.status(HttpStatus.GONE).build();
	}
	
	
	@Operation(summary="get Email by id",
			description="Get the Email info by spesifying its id. Response will be EmailResponse object.")
	@GetMapping("/emails/{id}")
	public ResponseEntity<EmailResponse> getEmailById(@PathVariable("id") String id){
		EmailResponse eMail=emailService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(eMail);
	}
}
