package com.example.domain;

import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "addresses")
@Setter
@Getter
public class Address {
	
	@MongoId
	@Field("_id")
	@JsonProperty("id")
	private UUID id;
	@Field("street")
	private String street;
	@Field("city")
	private String city;
	@Field("postal_code")
	private String postalCode;
	@Field("country")
	private String country;
	
	public Address() {
		id = UUID.randomUUID();
	}
	
}
