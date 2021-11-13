package com.example.domain;

import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "products")
@Setter
@Getter
public class Product {
	
	@MongoId
	@Field("_id")
	@JsonProperty("id")
	private UUID id;
	@Field("name")
	private String name;
	@Field("price")
	private double price;
	
	public Product() {
		id = UUID.randomUUID();
	}
	
}
