package com.TBmail.EmailService.Collections;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
@Document(collection="News")
public class News {
	@NonNull
    @Id
    @Setter(AccessLevel.NONE)
    private String id;
	
	@NonNull
    @Field("newsId")
	@Setter(AccessLevel.NONE)
    private String newsId;
	
	@Field("url")
	private String url;
	
	@Field("title")
    private String title;
	
	@Field("content")
    private String content;
	
	@Field("postDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime postDate;
	
	@DBRef
	@Field("newsCategoryId")
    private NewsCategory categoryId;

	public News() {
		this.newsId=Uid.generateUniqueId();
	}
	public News(String url, String title, String content, LocalDateTime postDate, NewsCategory categoryId ) {
		this.newsId=Uid.generateUniqueId();
		this.content=content;
		this.url=url;
		this.title=title;
		this.postDate=postDate;
		this.categoryId=categoryId;
		
	}
}
