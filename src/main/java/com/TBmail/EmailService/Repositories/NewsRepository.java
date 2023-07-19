package com.TBmail.EmailService.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.TBmail.EmailService.Collections.News;

public interface NewsRepository extends MongoRepository<News, String>{
	News findByNewsId(News  news);
    List<News> findAll();
    @SuppressWarnings("unchecked")
    News save(News news);
    void deleteById(String id);
    void deleteAll();
    List<News> findByTitle(String name);
    
}
