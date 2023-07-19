package com.TBmail.EmailService.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TBmail.EmailService.Collections.UserEmail;
import com.TBmail.EmailService.Repositories.UserEmailRepository;
import com.TBmail.EmailService.Response.UserEmailResponse;

@Service
public class UserEmailService {

	@Autowired
	private UserEmailRepository userEmailRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	public UserEmail findByUserId(String userId) {
		UserEmail userEmail= userEmailRepository.findByUserId(userId);
		return userEmail;
	}
	
	public UserEmailResponse findByUserIdR(String userId) {
		UserEmail userEmail= userEmailRepository.findByUserId(userId);
		return modelMapper.map(userEmail, UserEmailResponse.class);
	}
	
	public void deleteAllUserEmail() {
		userEmailRepository.deleteAll();
	}
	
	public boolean deleteAllUserEmailR() {
		userEmailRepository.deleteAll();
		return true;
	}
	
	public void addUserEmail(UserEmail userEmail) {
		userEmailRepository.save(userEmail);
	}
	
	public UserEmailResponse addUserEmailR(UserEmail userEmail) {
		UserEmail ue= userEmailRepository.save(userEmail);
		return modelMapper.map(ue, UserEmailResponse.class);
	}
}
