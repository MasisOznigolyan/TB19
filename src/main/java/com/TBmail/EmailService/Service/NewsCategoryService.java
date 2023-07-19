package com.TBmail.EmailService.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TBmail.EmailService.Collections.NewsCategory;
import com.TBmail.EmailService.Repositories.NewsCategoryRepository;
import com.TBmail.EmailService.Response.NewsCategoryResponse;

@Service
public class NewsCategoryService {
	
	@Autowired
	private NewsCategoryRepository newsCategoryRepository;
	@Autowired
	private ModelMapper modelMapper;
	
	public void addNewsCategory(NewsCategory category ) {
		newsCategoryRepository.save(category);
	}
	public NewsCategoryResponse addNewsCategoryR(NewsCategory category ) {
		NewsCategory nc=newsCategoryRepository.save(category);
		return modelMapper.map(nc, NewsCategoryResponse.class);
	}
	
	public void deleteAllNewsCategory() {
		newsCategoryRepository.deleteAll();
	}
	
	public boolean deleteAllNewsCategoryR() {
		newsCategoryRepository.deleteAll();
		return true;
	}
}
