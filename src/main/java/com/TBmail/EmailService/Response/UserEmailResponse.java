package com.TBmail.EmailService.Response;

import com.TBmail.EmailService.Collections.Email;
import com.TBmail.EmailService.Collections.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEmailResponse {
	
    private String id;
		

	private String userEmailId;
	
	
	private User userId;
	
	
	private Email emailId;
	
	@Override
	public String toString() {
		return "UserEmailResponse [id=" + id + ", userEmailId=" + userEmailId + ", userId=" + userId + ", emailId="
				+ emailId + "]";
	}

	
}
