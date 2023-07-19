package com.TBmail.EmailService.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TBmail.EmailService.Collections.UserCategory;
import com.TBmail.EmailService.Repositories.UserCategoryRepository;
import com.TBmail.EmailService.Response.UserCategoryResponse;

@Service
public class UserCategoryService {
	@Autowired
	private UserCategoryRepository userCategoryRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public UserCategory findByUserId(String userId) {
		return userCategoryRepository.findByUserId(userId);
	}
	public UserCategoryResponse findByUserIdR(String userId) {//
		UserCategory uc= userCategoryRepository.findByUserId(userId);
		return modelMapper.map(uc, UserCategoryResponse.class); 
	}
	
	public void deleteAllUserCategory() {//
		userCategoryRepository.deleteAll();
	}
	
	public boolean deleteAllUserCategoryR() {//
		userCategoryRepository.deleteAll();
		return true;
	}
	
	public void createUserCategory(UserCategory userCategory) {
		userCategoryRepository.save(userCategory);
	}
	
	public UserCategoryResponse createUserCategoryR(UserCategory userCategory) {
		UserCategory uc=userCategoryRepository.save(userCategory);
		return modelMapper.map(uc, UserCategoryResponse.class);
	}
}