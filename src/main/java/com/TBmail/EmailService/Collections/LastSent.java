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
@Document(collection = "LastSent")
public class LastSent {
	
	@NonNull
    @Id
    @Setter(AccessLevel.NONE)
    private String id;
		
	@NonNull
    @Field("LastSentId")
	@Setter(AccessLevel.NONE)
    private String LastSentId;
	
	@DBRef
	@Field("userEmailId")
	private UserEmail userEmailId;
	
	@DBRef
	@Field("newsId")
	private News newsId;
	
	public LastSent() {
		this.LastSentId=Uid.generateUniqueId();
	}
}
