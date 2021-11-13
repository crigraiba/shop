package com.example.domain;

import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "receipt_details")
@Setter
@Getter
public class ReceiptDetails {
	
	@MongoId
	@Field("_id")
	@JsonProperty("id")
	private UUID id;
	@Field("product_id")
	private Product product;
	@Field("receipt_id")
	private Receipt receipt;
	
	public ReceiptDetails() {
		id = UUID.randomUUID();
	}
	
}
