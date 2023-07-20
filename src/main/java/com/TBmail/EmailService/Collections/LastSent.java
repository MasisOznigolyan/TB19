package com.TBmail.EmailService.Collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LastSent {
	
	@NonNull
    @Id
    //@Setter(AccessLevel.NONE)
    @JsonProperty("id")
    private String id;
		
	@NonNull
    @Field("LastSentId")
	//@Setter(AccessLevel.NONE)
	@JsonProperty("LastSentId")
    private String LastSentId;
	
	@DBRef
	@Field("userEmailId")
	@JsonProperty("userEmailId")
	private UserEmail userEmailId;
	
	@DBRef
	@Field("newsId")
	@JsonProperty("newsId")
	private News newsId;
	
	public LastSent() {
		this.LastSentId=Uid.generateUniqueId();
	}
}
