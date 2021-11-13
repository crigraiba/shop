package com.example.service;

import java.util.List;
import java.util.UUID;

import com.example.domain.Receipt;

public interface ReceiptService {
	
	public List<Receipt> read();
	
	public Receipt readById(UUID id);
	
	public Receipt create(Receipt receipt);
	
	public Receipt update(Receipt receipt);
	
	public void delete(Receipt receipt);
	
}
