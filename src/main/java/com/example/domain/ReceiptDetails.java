package com.example.domain;

import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "receipt_details")
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
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}
	
	public UUID getId() {
		return id;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public Receipt getReceipt() {
		return receipt;
	}
	
}
