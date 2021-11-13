package com.example.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.exception.ResourceNotFoundException;
import com.example.domain.ReceiptDetails;
import com.example.repository.IReceiptDetailsRepository;

@Service
public class ReceiptDetailsService {
	
	@Autowired
	private IReceiptDetailsRepository repository;
	
	public List<ReceiptDetails> read() {
		return repository.findAll();
	}
	
	public ReceiptDetails readById(UUID id) {
		return repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("ReceiptDetails with id: " + id + " doesn't exist"));
	}
	
	public ReceiptDetails create(ReceiptDetails receiptDetails) {
		return repository.save(receiptDetails);
	}
	
	public ReceiptDetails update(ReceiptDetails receiptDetails) {
		this.readById(receiptDetails.getId());
		
		return repository.save(receiptDetails);
	}
	
	public void delete(ReceiptDetails receiptDetails) {
		repository.delete(receiptDetails);
	}
	
}
