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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="User-Category", description="Controller for userCategory CRUD operations")
@RestController
public class UserCategoryController {
	@Autowired
	UserCategoryService userCategoryService;
	
	
	@Operation(summary="get userCategory by id",
			description="Get the userCategory info by spesifying its id. Response will be userCategoryResponse object.")
	@GetMapping("/userCategory/{id}")
	public ResponseEntity<UserCategoryResponse> findByUserId(@PathVariable("id") String id){
		UserCategoryResponse ucr=userCategoryService.findByUserIdR(id);
		return ResponseEntity.status(HttpStatus.OK).body(ucr);
	}
	
	
	@Operation(summary="create/update userCategory",
			description="create/update by spesifying UserCategory body. Response will be UserCategoryResponse object")
	@PostMapping("/userCategory/create")
	public ResponseEntity<UserCategoryResponse>createUserCategory(UserCategory userCategory){
		UserCategoryResponse res = userCategoryService.createUserCategoryR(userCategory);
		return ResponseEntity.status(HttpStatus.CREATED).body(res);
	}
	
	
	@Operation(summary="delete all the userCategory",
			description="deletes all the userCategories from database. Do not use if if you don't have database backup")
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
