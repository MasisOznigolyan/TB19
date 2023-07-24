package com.TBmail.EmailService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TBmail.EmailService.Collections.NewsCategory;
import com.TBmail.EmailService.Response.NewsCategoryResponse;
import com.TBmail.EmailService.Service.NewsCategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="News-Category", description="Controller for NewsCategory CRUD operations")
@RestController
public class NewsCategoryController {

	@Autowired
	NewsCategoryService newsCategoryService;
	
	@Operation(summary="create/update NewsCategory",
			description="create/update by spesifying NewsCategory. Response will be NewsCategoryResponse object")
	@PostMapping("/NewsCategory/add")
	public ResponseEntity<NewsCategoryResponse> addNewsCategory(NewsCategory newsCategory){
		NewsCategoryResponse ncr=newsCategoryService.addNewsCategoryR(newsCategory);
		return ResponseEntity.status(HttpStatus.CREATED).body(ncr);
	}
	
	
	@Operation(summary="delete all NewsCategory",
			description="deletes all the NewsCategory from database. Do not use if if you don't have database backup")
	@DeleteMapping("/NewsCategory/delete")
	public ResponseEntity<Void> deleteAllNewsCategory(){
		boolean deleted=newsCategoryService.deleteAllNewsCategoryR();
		if (deleted) {
	        return ResponseEntity.status(HttpStatus.GONE).build(); 
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }
	}
}
