package com.TBmail.EmailService.Response;

import com.TBmail.EmailService.Collections.Uid;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class NewsCategoryResponse {
	
    //private String id;
		
	
    private String newsCategoryId;
	
	
    private String name;
	
	
    private String categoryUrl;

	public NewsCategoryResponse() {
		this.newsCategoryId=Uid.generateUniqueId();
	}
}