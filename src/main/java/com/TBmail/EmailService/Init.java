package com.TBmail.EmailService;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TBmail.EmailService.Collections.Email;
import com.TBmail.EmailService.Collections.LastSent;
import com.TBmail.EmailService.Collections.News;
import com.TBmail.EmailService.Collections.NewsCategory;
import com.TBmail.EmailService.Collections.User;
import com.TBmail.EmailService.Collections.UserCategory;
import com.TBmail.EmailService.Collections.UserEmail;
import com.TBmail.EmailService.Parser.GetHead;
import com.TBmail.EmailService.Parser.LastNews;
import com.TBmail.EmailService.Parser.MailContent;
import com.TBmail.EmailService.Service.EmailService;
import com.TBmail.EmailService.Service.LastSentService;
import com.TBmail.EmailService.Service.NewsCategoryService;
import com.TBmail.EmailService.Service.NewsService;
import com.TBmail.EmailService.Service.UserCategoryService;
import com.TBmail.EmailService.Service.UserEmailService;
import com.TBmail.EmailService.Service.UserService;

//@Component
@Service
public class Init {
	@Autowired
	UserService userService;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	NewsCategoryService newsCategoryService;
	
	@Autowired
	NewsService newsService;
	
	@Autowired
	LastSentService lastSentService;
	
	@Autowired
	UserCategoryService userCategoryService;
	
	@Autowired
	UserEmailService userEmailService;
	
	@Autowired 
	ModelMapper modelMapper;
	public void initDb() {     
	
		
        userService.deleteAllUsers();
        emailService.deleteAllEmails();
        newsCategoryService.deleteAllNewsCategory();
        userCategoryService.deleteAllUserCategory();
        newsService.deleteAllNews(); 
        lastSentService.deleteAllLastSent();
        userEmailService.deleteAllUserEmail();
        
        User user1 = new User();
       
        user1.setName("Mikael Öznigolyan");
        userService.createUser(user1);
        
        Email email1=new Email();
        email1.setEMail("oznigolyan3@gmail.com");
       
        
       emailService.createNewEmail(email1);
        userService.createUser(user1);
        UserEmail ue= new UserEmail();
        ue.setEmailId(email1);
        ue.setUserId(user1);
        userEmailService.addUserEmail(ue);
        
        User user2 = new User();
        user2.setName("Masis Öznigolyan");
        
        userService.createUser(user2);
        
        Email email2=new Email();
        email2.setEMail("oznigolyan3@stu.khas.edu.tr");
       
       emailService.createNewEmail(email2);
        
        
        UserEmail ue1= new UserEmail();
        ue1.setEmailId(email2);
        ue1.setUserId(user2);
        userEmailService.addUserEmail(ue1);
        
        NewsCategory category= new NewsCategory();
        category.setName("Darrüşaffaka Lassa");
        category.setCategoryUrl("https://trendbasket.net/tag/darussafaka-lassa/");
        newsCategoryService.addNewsCategory(category);
        
        NewsCategory category2= new NewsCategory();
        category2.setName("Fenerbahçe Beko");
        category2.setCategoryUrl("https://trendbasket.net/tag/fenerbahce-beko/");
        newsCategoryService.addNewsCategory(category2);
        
        UserCategory uk= new UserCategory();
        uk.setUserId(user1);
        uk.setNewsCategoryId(category2);
        userCategoryService.createUserCategory(uk);
        
        UserCategory uk1= new UserCategory();
        uk1.setUserId(user2);
        uk1.setNewsCategoryId(category);
        userCategoryService.createUserCategory(uk1);
        
        String url="https://trendbasket.net/turkish-airlines-euroleague-takimlarinin-2023-24-sezonu-kadrolari/";
        String page= MailContent.getHtml(url);
        
        
        
        String title=GetHead.getHead(page);
        String content=MailContent.getContent(url);
        String postDate=LastNews.getLastNewsTime(url);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(postDate, formatter);
        
        ZoneId gmtPlus3 = ZoneId.of("GMT+3");
        ZonedDateTime zonedDateTime = localDateTime.atZone(gmtPlus3);
        LocalDateTime dateTime = zonedDateTime.toLocalDateTime();
        
        News news1= new News(url,title,content,dateTime,category2 );
        newsService.addNews(news1);
        
        LastSent lastSent= new LastSent();
        lastSent.setUserEmailId(ue);
        lastSent.setNewsId(news1);
        lastSentService.addLastSent(lastSent);
        
        String url1 = "https://trendbasket.net/basketbol-sampiyonlar-liginde-temsilcilerimizin-gruplari-belli-oldu/";
        String page1 =MailContent.getHtml(url1);
        
        String title1 = GetHead.getHead(page1);
        String content1 = MailContent.getContent(url1);
        String postDate1 = LastNews.getLastNewsTime(url1);
        
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime localDateTime1 = LocalDateTime.parse(postDate1, formatter1);

        ZonedDateTime zonedDateTime1 = localDateTime1.atZone(gmtPlus3);
        LocalDateTime dateTime1 = zonedDateTime1.toLocalDateTime();
        
        
        News news2 = new News(url1, title1, content1, dateTime1, category); 
        newsService.addNews(news2);
        
        LastSent lastSent2 = new LastSent();
        lastSent2.setUserEmailId(ue1);
        lastSent2.setNewsId(news2);
        lastSentService.addLastSent(lastSent2);
        
	 
	
	
		
	}
}
