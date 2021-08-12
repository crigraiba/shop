package com.example.domain;

import java.util.UUID;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "users")
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
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setRole(ERole role) {
		this.role = role;
	}
	
	public UUID getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public ERole getRole() {
		return role;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", role=" + role + "]";
	}
	
}
