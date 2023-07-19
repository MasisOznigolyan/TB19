package com.TBmail.EmailService.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
	//private String id;
    private String userId;
	
	private String name;

	@Override
	public String toString() {
		return "UserResponse [ userId=" + userId + ", name=" + name + "]";
	}
	
}
