package com.TBmail.EmailService.Response;

import com.TBmail.EmailService.Collections.NewsCategory;
import com.TBmail.EmailService.Collections.User;

import lombok.Getter;
import lombok.Setter;

public class UserCategoryResponse {
	@Getter
	@Setter
	public class UserCategory {
		
	    //private String id;
		
		
	    private String userCategoryId;
		
	
		private User userId;
		
		
		private NewsCategory newsCategoryId;
	}
}
