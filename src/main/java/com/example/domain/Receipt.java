package com.example.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "receipts")
@Setter
@Getter
public class Receipt {
	
	@MongoId
	@Field("_id")
	@JsonProperty("id")
	private UUID id;
	@Field("created_at")
	private LocalDateTime createdAt;
	
	public Receipt() {
		id = UUID.randomUUID();
	}
	
}
