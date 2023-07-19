package com.TBmail.EmailService;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.TBmail.EmailService.Collections.LastSent;
import com.TBmail.EmailService.Collections.News;
import com.TBmail.EmailService.Collections.User;
import com.TBmail.EmailService.Collections.UserCategory;
import com.TBmail.EmailService.Collections.UserEmail;
import com.TBmail.EmailService.Parser.GetHead;
import com.TBmail.EmailService.Parser.LastNews;
import com.TBmail.EmailService.Parser.MailContent;
import com.TBmail.EmailService.Response.UserEmailResponse;
import com.TBmail.EmailService.Service.EmailService;
import com.TBmail.EmailService.Service.LastSentService;
import com.TBmail.EmailService.Service.NewsService;
import com.TBmail.EmailService.Service.UserCategoryService;
import com.TBmail.EmailService.Service.UserEmailService;
import com.TBmail.EmailService.Service.UserService;

@EnableScheduling
@Component
@Service
public class ScheduledTask {
	

	@Autowired
	UserService userService;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	NewsService newsService;
	
	@Autowired
	LastSentService lastSentService;
	
	@Autowired
	UserCategoryService userCategoryService;
	
	@Autowired
	UserEmailService userEmailService;
	
	@Autowired
	Init init;
	
	@Autowired
	ModelMapper modelMapper;
	
	RestTemplate restTemplate = new RestTemplate();

	
	@Autowired
	private EmailSenderService senderService;
	
	//@Scheduled(cron = "0 * * * * *")   //   "0 10/2 * * *" 
public void sendMail() {
		
		//init.initDb();
		
		
		List<User> data=userService.getAllUsers(); 
		
		System.out.println(data);
		System.out.println("+-+-+-+-+-+-+-+");
		for(int i=0; i<data.size(); i++) {
			UserCategory uC=userCategoryService.findByUserId(data.get(i).getId());
			String tag=uC.getNewsCategoryId().getCategoryUrl();		
			ArrayList<String> urls=new ArrayList<String>(); 
			for(int j=0; j<20; j++) {
				//System.out.println(LastNews.getNewsUrl(MailContent.getHtml(tag)));
				String t1=LastNews.getNewsUrl(MailContent.getHtml(tag));
				urls.add(t1);
				
			}
			//Email eMail=userEmailService.findByUserId(data.get(i).getId()).getEmailId(); 
			UserEmail userem=userEmailService.findByUserId(data.get(i).getId()); 
			//UserEmail ue=new UserEmail(userem.getId(),userem.getUserEmailId(),userem.getUserId(),userem.getEmailId());
			LastSent ls=lastSentService.findByUserEmailId(userem);
			//System.out.println(ls);
			News n=ls.getNewsId();
			String lastSent=n.getUrl();
			//System.out.println("last sent is "+lastSent);
			//System.out.println("last news in website is "+urls.get(0));
			if(!(urls.get(0).equals(lastSent))) {
				System.out.println("mail is being sent");
				ArrayList<String> mailUrls=new ArrayList<String>();
				int index=urls.indexOf(lastSent);
				System.out.println(index);
				if(index!=-1) {
					LastNews.resetIndex();
					for(int j=index-1; j>=0; j--) {
						mailUrls.add(urls.get(j));
					}
				}
				else{
					for(int j=0; j<urls.size(); j++) {
						mailUrls.add(urls.get(j));
					}
				}
				
				
				for(int j=0; j<mailUrls.size(); j++) {
					
					System.out.println("Following news will be sent: "+mailUrls.get(j));
					//senderService.sendEmail(UserService.emailRepository.findByUserId(data.get(i).getId()).getEMail(),"TB özet",mailUrls.get(j) ); //MailContent.getContent(mailUrls.get(j))
					News news=new News();
					news.setContent(MailContent.getContent(mailUrls.get(j)));
					news.setUrl(mailUrls.get(j));
					
					
					 String page =MailContent.getHtml(mailUrls.get(j));
				        
				     String title = GetHead.getHead(page);
				     news.setTitle(title);
				     
				     
				     String postDate = LastNews.getLastNewsTime(mailUrls.get(j));
				        
				     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
				     LocalDateTime localDateTime = LocalDateTime.parse(postDate, formatter);
				     ZoneId gmtPlus3 = ZoneId.of("GMT+3");
				     ZonedDateTime zonedDateTime = localDateTime.atZone(gmtPlus3);
				     LocalDateTime dateTime = zonedDateTime.toLocalDateTime();
				     news.setPostDate(dateTime);
				     news.setCategoryId(uC.getNewsCategoryId());
				     newsService.addNews(news);
					
					
					if(j==mailUrls.size()-1) {
						//update lastSent
						//userem=userEmailService.findByUserId(data.get(i).getId());
						//ue=new UserEmail(userem.getId(),userem.getUserEmailId(),userem.getUserId(),userem.getEmailId());
						LastSent url=lastSentService.findByUserEmailId(userEmailService.findByUserId(data.get(i).getId()));//!!!!!!!!!!!!!!!!!!!!
						//System.out.println(url.getNewsId().getUrl());
						
						url.setNewsId(news);
						lastSentService.addLastSent(url);
						
					
					}
					
				}
				
				
				
			}
			else
				System.out.println("New news is not found");
			
			
			
			LastNews.resetIndex();
			
			
		}
		
		
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println("Waiting...");
		System.out.println("current date and time is: "+dtf.format(now));
		
		System.out.println("++++++++++++++++++++++++++++++++++++");
		
	}

	
	
	public List<User> getUsersFromAddress(String address) {
	    ResponseEntity<User[]> responseEntity = restTemplate.exchange(address,HttpMethod.GET,null, User[].class);

	    if (responseEntity.getStatusCode() == HttpStatus.OK) {
	        User[] users = responseEntity.getBody();
	        return Arrays.asList(users);
	    } else {
	        // Handle the case when the request is not successful
	        return Collections.emptyList();
	    }
	}
	
	public UserEmail convertToUserEmail(UserEmailResponse userEmailResponse) {
        return modelMapper.map(userEmailResponse, UserEmail.class);
    }
}
