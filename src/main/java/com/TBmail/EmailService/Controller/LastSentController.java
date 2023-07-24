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
import com.TBmail.EmailService.Response.LastSentResponse;
import com.TBmail.EmailService.Service.LastSentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name="LastSent", description="Controller for LastSent CRUD operations")
public class LastSentController {

	@Autowired
	LastSentService lastSentService;
	@Operation(summary="get LastSent by UserEmailId",
			description="Get the LastSent info by spesifying UserEmailId. Response will be LastSentResponse object.")
	@GetMapping("/lastSent/{user}")
	public ResponseEntity<LastSentResponse> findByUserEmail(@PathVariable("user") String userEmail){
		LastSentResponse res=lastSentService.findByUserEmailIdR(userEmail);
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}
	
	
	@Operation(summary="create/update lastSent",
			description="create/update by spesifying lastSent body. Response will be LastSentResponse object")
	@PostMapping("/lastSent/add")
	public ResponseEntity<LastSentResponse> addLastSent(LastSent lastSent){
		LastSentResponse lsr=lastSentService.addLastSentR(lastSent);
		return ResponseEntity.status(HttpStatus.OK).body(lsr);
	}
	
	
	@Operation(summary="delete all lastSent",
			description="deletes all lastSents from database. Do not use if if you don't have database backup")
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
