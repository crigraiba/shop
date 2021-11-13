package com.example.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.exception.ResourceNotFoundException;
import com.example.domain.ReceiptDetails;
import com.example.repository.IReceiptDetailsRepository;
import com.example.service.ReceiptDetailsService;

@Service
public class ReceiptDetailsServiceImpl implements ReceiptDetailsService {
	
	@Autowired
	private IReceiptDetailsRepository repository;
	
	@Override
	public List<ReceiptDetails> read() {
		return repository.findAll();
	}
	
	@Override
	public ReceiptDetails readById(UUID id) {
		return repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("ReceiptDetails with id: " + id + " doesn't exist"));
	}
	
	@Override
	public ReceiptDetails create(ReceiptDetails receiptDetails) {
		return repository.save(receiptDetails);
	}
	
	@Override
	public ReceiptDetails update(ReceiptDetails receiptDetails) {
		this.readById(receiptDetails.getId());
		
		return repository.save(receiptDetails);
	}
	
	@Override
	public void delete(ReceiptDetails receiptDetails) {
		repository.delete(receiptDetails);
	}
	
}
