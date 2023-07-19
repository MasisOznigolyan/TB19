package com.TBmail.EmailService.Collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection="UserCategory")
public class UserCategory {
	@NonNull
    @Id
    @Setter(AccessLevel.NONE)
    private String id;
	
	@NonNull
    @Field("userCategoryId")
	@Setter(AccessLevel.NONE)
    private String userCategoryId;
	
	@DBRef
	@Field("userId")
	private User userId;
	
	@DBRef
	@Field("newsCategoryId")
	private NewsCategory newsCategoryId;
}
