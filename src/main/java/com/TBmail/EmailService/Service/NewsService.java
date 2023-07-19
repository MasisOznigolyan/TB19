package com.TBmail.EmailService.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TBmail.EmailService.Collections.News;
import com.TBmail.EmailService.Repositories.NewsRepository;
import com.TBmail.EmailService.Response.NewsResponse;

@Service
public class NewsService {
	
	@Autowired
	private NewsRepository newsRepository;
	@Autowired
	private ModelMapper modelmapper;
	
	public void addNews(News news) {
		newsRepository.save(news);
	}
	public NewsResponse addNewsR(News news) {
		News newNews= newsRepository.save(news);
		return modelmapper.map(newNews, NewsResponse.class);
	}
	
	public void deleteAllNews() {
		newsRepository.deleteAll();
	}
	public boolean deleteAllNewsR() {
		newsRepository.deleteAll();
		return true;
	}
}
