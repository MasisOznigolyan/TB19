package com.TBmail.EmailService.Response;

import com.TBmail.EmailService.Collections.News;
import com.TBmail.EmailService.Collections.Uid;
import com.TBmail.EmailService.Collections.UserEmail;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class LastSentResponse {
	
    //private String id;
		
	
    private String LastSentId;
	
	
	private UserEmail userEmailId;
	
	
	private News newsId;
	
	public LastSentResponse() {
		this.LastSentId=Uid.generateUniqueId();
	}
}
