package com.TBmail.EmailService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TBmail.EmailService.Collections.UserCategory;
import com.TBmail.EmailService.Response.UserCategoryResponse;
import com.TBmail.EmailService.Service.UserCategoryService;

@RestController
public class UserCategoryController {
	@Autowired
	UserCategoryService userCategoryService;
	
	@GetMapping("/userCategory/{id}")
	public ResponseEntity<UserCategoryResponse> findByUserId(@PathVariable("id") String id){
		UserCategoryResponse ucr=userCategoryService.findByUserIdR(id);
		return ResponseEntity.status(HttpStatus.OK).body(ucr);
	}
	
	@PostMapping("/userCategory/create")
	public ResponseEntity<UserCategoryResponse>createUserCategory(UserCategory userCategory){
		UserCategoryResponse res = userCategoryService.createUserCategoryR(userCategory);
		return ResponseEntity.status(HttpStatus.CREATED).body(res);
	}
	@DeleteMapping("/userCategory/delete")
	public ResponseEntity<Void> deleteAllUserCategory(){
		boolean deleted=userCategoryService.deleteAllUserCategoryR();		
		if (deleted) {
	        return ResponseEntity.status(HttpStatus.GONE).build(); 
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }
	}
}
