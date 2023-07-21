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

@RestController
//@EnableSwagger2
//@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/users/{id}")
	public ResponseEntity<UserResponse> getUserDetails(@PathVariable("id") String UserId){
		
		UserResponse user=userService.getUserByUserId(UserId);
		
		
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<UserResponse>> getAllUsers(){
		
		List<UserResponse> userList=userService.getAllUsersR();
		return ResponseEntity.status(HttpStatus.OK).body(userList);
		
		
	}
	
	@PostMapping("/users/create")
	public ResponseEntity<UserResponse>  createUser(@RequestBody User newUser){
		UserResponse user=userService.createUser(newUser);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
	
	@DeleteMapping("/users/delete/{id}")
	public ResponseEntity<Void> deleteUserById(@PathVariable("id") String userId) {
	    boolean deleted = userService.deleteUser(userId);
	    if (deleted) {
	        return ResponseEntity.status(HttpStatus.GONE).build(); 
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }
	}
	@DeleteMapping("/users/delete")
	public ResponseEntity<Void> deleteAllUsers(){
		userService.deleteAllUsers();
		return ResponseEntity.status(HttpStatus.GONE).build();
	}
	
}
