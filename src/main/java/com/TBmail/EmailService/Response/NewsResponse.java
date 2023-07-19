package com.TBmail.EmailService.Response;

import java.time.LocalDateTime;

import com.TBmail.EmailService.Collections.NewsCategory;
import com.TBmail.EmailService.Collections.Uid;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class NewsResponse {
	
    //private String id;
	
	
    private String newsId;
	
	
	private String url;
	
	
    private String title;
	
	
    private String content;
	
    private LocalDateTime postDate;
	
    private NewsCategory categoryId;

	public NewsResponse() {
		this.newsId=Uid.generateUniqueId();
	}
	public NewsResponse(String url, String title, String content, LocalDateTime postDate, NewsCategory categoryId ) {
		this.newsId=Uid.generateUniqueId();
		this.content=content;
		this.url=url;
		this.title=title;
		this.postDate=postDate;
		this.categoryId=categoryId;
		
	}
}
