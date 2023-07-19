package com.TBmail.EmailService.Collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;


@Data
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "Email")
public class Email {


	@NonNull
    @Id
    @Setter(AccessLevel.NONE)
    private String id;
		
	@NonNull
    @Field("eMailId")
	@Setter(AccessLevel.NONE)
    private String eMailId;
	
	
	 @Field("eMail")
	 private String eMail;
	 
	 
	 
	 public Email(){
		 this.eMailId=Uid.generateUniqueId();
	 }
	 
	 
	 
}
