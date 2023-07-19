package com.TBmail.EmailService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TBmail.EmailService.Collections.LastSent;
import com.TBmail.EmailService.Collections.UserEmail;
import com.TBmail.EmailService.Response.LastSentResponse;
import com.TBmail.EmailService.Service.LastSentService;

@RestController
public class LastSentController {

	@Autowired
	LastSentService lastSentService;
	
	@GetMapping("/lastSent/{user}")
	public ResponseEntity<LastSentResponse> findByUserEmail(@PathVariable("user") UserEmail userEmail){
		LastSentResponse res=lastSentService.findByUserEmailIdR(userEmail);
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}
	@PostMapping("/lastSent/add")
	public ResponseEntity<LastSentResponse> addLastSent(LastSent lastSent){
		LastSentResponse lsr=lastSentService.addLastSentR(lastSent);
		return ResponseEntity.status(HttpStatus.CREATED).body(lsr);
	}
	@DeleteMapping("/lastSent/delete")
	public ResponseEntity<Void> deleteAllLastSent(){
		boolean deleted=lastSentService.deleteAllLastSentR();
		if (deleted) {
	        return ResponseEntity.status(HttpStatus.GONE).build(); 
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }
	}
}
