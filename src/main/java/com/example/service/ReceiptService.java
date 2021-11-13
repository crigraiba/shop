package com.example.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.exception.ResourceNotFoundException;
import com.example.domain.Receipt;
import com.example.repository.IReceiptRepository;

@Service
public class ReceiptService {
	
	@Autowired
	private IReceiptRepository repository;
	
	public List<Receipt> read() {
		return repository.findAll();
	}
	
	public Receipt readById(UUID id) {
		return repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Receipt with id: " + id + " doesn't exist"));
	}
	
	public Receipt create(Receipt receipt) {
		return repository.save(receipt);
	}
	
	public Receipt update(Receipt receipt) {
		this.readById(receipt.getId());
		
		return repository.save(receipt);
	}
	
	public void delete(Receipt receipt) {
		repository.delete(receipt);
	}
	
}
