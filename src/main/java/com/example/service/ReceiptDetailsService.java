package com.example.service;

import java.util.List;
import java.util.UUID;

import com.example.domain.ReceiptDetails;

public interface ReceiptDetailsService {
	
	public List<ReceiptDetails> read();
	
	public ReceiptDetails readById(UUID id);
	
	public ReceiptDetails create(ReceiptDetails receipt);
	
	public ReceiptDetails update(ReceiptDetails receipt);
	
	public void delete(ReceiptDetails receipt);
	
}
