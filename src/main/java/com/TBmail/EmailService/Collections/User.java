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
@Document(collection = "users")
public class User {
	
	@NonNull
    @Id
    @Setter(AccessLevel.NONE)
    private String id;
		
	@NonNull
    @Field("userId")
	@Setter(AccessLevel.NONE)
    private String userId;
	
	@Field("name")
	private String name;
    

	public User() {
		this.userId=Uid.generateUniqueId();
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + "]";
	}

	
	
}

