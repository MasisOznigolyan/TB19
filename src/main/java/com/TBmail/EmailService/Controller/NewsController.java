package com.TBmail.EmailService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TBmail.EmailService.Collections.News;
import com.TBmail.EmailService.Response.NewsResponse;
import com.TBmail.EmailService.Service.NewsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="News", description="Controller for News CRUD operations")
@RestController
public class NewsController {
	@Autowired
	NewsService newsService;
	
	
	@Operation(summary="create/update News",
			description="create/update by spesifying News object. Response will be NewsResponse object")
	@PostMapping("News/add")
	public ResponseEntity<NewsResponse> addNews(News news){
		NewsResponse nR=newsService.addNewsR(news);
		return ResponseEntity.status(HttpStatus.CREATED).body(nR);
	}
	
	
	@Operation(summary="delete all the News",
			description="deletes all the News from database. Do not use if if you don't have database backup")
	@DeleteMapping("News/delete")
	public ResponseEntity<Void> deleteAllNews(){
		boolean deleted=newsService.deleteAllNewsR();
		if (deleted) {
	        return ResponseEntity.status(HttpStatus.GONE).build(); 
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }
	}
}
