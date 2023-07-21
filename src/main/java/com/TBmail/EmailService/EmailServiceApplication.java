package com.TBmail.EmailService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
//@EnableSwagger2
public class EmailServiceApplication  {
	
	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
	
	
	public static void main(String[] args) {
		SpringApplication.run(EmailServiceApplication .class, args);
		
		
	}
	
	public void getRequest() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		restTemplate.getForObject("http://localhost:8080/tb/mail", String.class);
		
	}

}
