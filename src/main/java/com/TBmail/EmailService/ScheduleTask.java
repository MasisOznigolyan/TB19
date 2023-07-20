package com.TBmail.EmailService;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.TBmail.EmailService.Response.UserResponse;


@EnableScheduling
@Component
@Service
public class ScheduleTask {

	@Autowired
	private EmailSenderService senderService;
	
	//@Scheduled(cron = "0 * * * * *")
	public void sendMail() {
		
		List<UserResponse> data=getAllUsersFromAPI();
		System.out.println(data);
	}
	
	public List<UserResponse> getAllUsersFromAPI() {
        // Create a RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // Make an HTTP GET request to the desired endpoint
        String apiUrl = "http://localhost:8080/users"; // Replace this URL with your actual API endpoint
        ResponseEntity<UserResponse[]> responseEntity = restTemplate.getForEntity(apiUrl, UserResponse[].class);
        
        // Extract the list of UserResponse from the response body
        List<UserResponse> userList = Arrays.asList(responseEntity.getBody());

        return userList;
    }
}
