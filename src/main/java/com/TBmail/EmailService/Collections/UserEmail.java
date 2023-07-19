package com.TBmail.EmailService.Collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
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
@Document(collection="userEmail")
public class UserEmail {

	@NonNull
    @Id
    @Setter(AccessLevel.NONE)
    private String id;
		
	@NonNull
    @Field("userEmailId")
	@Setter(AccessLevel.NONE)
    private String userEmailId;
	
	@NonNull
	@DBRef
    @Field("userId")
	private User userId;
	
	@NonNull
	@DBRef
    @Field("emailId")
	private Email emailId;
	
	public UserEmail() {
		this.userEmailId=Uid.generateUniqueId();
	}
}
