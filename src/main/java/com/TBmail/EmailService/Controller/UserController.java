package com.TBmail.EmailService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TBmail.EmailService.Collections.User;
import com.TBmail.EmailService.Response.UserResponse;
import com.TBmail.EmailService.Service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="User", description="Controller for user CRUD operations")
@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@Operation(summary="get user by id",
			description="Get the user info by spesifying its id. Response will be userResponse object.")
	@GetMapping("/users/{id}")
	public ResponseEntity<UserResponse> getUserDetails(@Parameter(description = "Unique id of User object") @PathVariable("id") String UserId){
		
		UserResponse user=userService.getUserByUserId(UserId);

		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	
	@Operation(summary="get all the users",
			description="Get the user info in TB database. Response will be the list of UserResponse objects")
	@GetMapping("/users")
	public ResponseEntity<List<UserResponse>> getAllUsers(){
		
		List<UserResponse> userList=userService.getAllUsersR();
		return ResponseEntity.status(HttpStatus.OK).body(userList);
	}
	
	
	@Operation(summary="create/update user",
			description="create/update by spesifying User type body. Response will be UserResponse object")
	@PostMapping("/users/create")
	public ResponseEntity<UserResponse>  createUser(@RequestBody User newUser){
		UserResponse user=userService.createUser(newUser);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
	
	
	@Operation(summary="delete user by id",
			description="delete user by spesifying its id.")
	@DeleteMapping("/users/delete/{id}")
	public ResponseEntity<Void> deleteUserById(@PathVariable("id") String userId) {
	    boolean deleted = userService.deleteUser(userId);
	    if (deleted) {
	        return ResponseEntity.status(HttpStatus.GONE).build(); 
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }
	}
	
	
	@Operation(summary="delete all the users",
			description="deletes all the users from database. Do not use if if you don't have database backup")
	@DeleteMapping("/users/delete")
	public ResponseEntity<Void> deleteAllUsers(){
		userService.deleteAllUsers();
		return ResponseEntity.status(HttpStatus.GONE).build();
	}

}
