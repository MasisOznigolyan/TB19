package com.TBmail.EmailService.Response;

import com.TBmail.EmailService.Collections.NewsCategory;
import com.TBmail.EmailService.Collections.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCategoryResponse {
	
	    private String id;


		private String userCategoryId;
		
	
		private User userId;
		
		
		private NewsCategory newsCategoryId;
		
		@Override
		public String toString() {
			return "UserCategory [id=" + id + ", userCategoryId=" + userCategoryId + ", userId=" + userId
					+ ", newsCategoryId=" + newsCategoryId + "]";
		}
}
