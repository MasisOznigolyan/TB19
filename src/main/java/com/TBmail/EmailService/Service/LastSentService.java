package com.TBmail.EmailService.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TBmail.EmailService.Collections.LastSent;
import com.TBmail.EmailService.Collections.UserEmail;
import com.TBmail.EmailService.Repositories.LastSentRepository;
import com.TBmail.EmailService.Response.LastSentResponse;
@Service
public class LastSentService {

	@Autowired
	private LastSentRepository lastSentRepository;
	@Autowired
	private ModelMapper modelMapper;
	
	public void addLastSent(LastSent lastSent) {
		lastSentRepository.save(lastSent);
	}
	
	public LastSentResponse addLastSentR(LastSent lastSent) {
		LastSent ls=lastSentRepository.save(lastSent);
		return modelMapper.map(ls,LastSentResponse.class );
	}
	
	public LastSent findByUserEmailId(UserEmail userEmail) {
		return lastSentRepository.findByUserEmailId(userEmail);
		 
				 
	}
	public LastSentResponse findByUserEmailIdR(UserEmail userEmail) {
		LastSent res= lastSentRepository.findByUserEmailId(userEmail);
		 return modelMapper.map(res,LastSentResponse.class);
	}
	
	public void deleteAllLastSent() {
		lastSentRepository.deleteAll();
	}
	
	public boolean deleteAllLastSentR() {
		lastSentRepository.deleteAll();
		return true;
	}
}
