package com.TBmail.EmailService.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.TBmail.EmailService.Collections.NewsCategory;

public interface NewsCategoryRepository extends MongoRepository<NewsCategory,String>{
	NewsCategory findByNewsCategoryId(String NewsCategoryId);
    List<NewsCategory> findAll();
    @SuppressWarnings("unchecked")
    NewsCategory save(NewsCategory newsCategory);
    void deleteById(String id);
    void deleteAll();
    List<NewsCategory> findByName(String name);
    
}