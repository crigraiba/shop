package com.example.domain;

import java.util.UUID;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "users")
@Setter
@Getter
public class User {
	
	@MongoId
	@Field("_id")
	@JsonProperty("id")
	private UUID id;
	@Field("email")
	@Indexed(unique = true)
	private String email;
	@Field("password")
	private String password;
	@Field("role")
	private ERole role;
	
	public User() {
		id = UUID.randomUUID();
	}
	
}
