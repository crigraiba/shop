package com.example.domain;

import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "addresses")
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
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public UUID getId() {
		return id;
	}
	
	public String getStreet() {
		return street;
	}
	
	public String getCity() {
		return city;
	}
	
	public String setPostalCode() {
		return postalCode;
	}
	
	public String getCountry() {
		return country;
	}
	
}
