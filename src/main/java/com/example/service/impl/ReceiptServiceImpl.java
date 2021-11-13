package com.example.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.exception.ResourceNotFoundException;
import com.example.domain.Receipt;
import com.example.repository.IReceiptRepository;
import com.example.service.ReceiptService;

@Service
public class ReceiptServiceImpl implements ReceiptService {
	
	@Autowired
	private IReceiptRepository repository;
	
	@Override
	public List<Receipt> read() {
		return repository.findAll();
	}
	
	@Override
	public Receipt readById(UUID id) {
		return repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Receipt with id: " + id + " doesn't exist"));
	}
	
	@Override
	public Receipt create(Receipt receipt) {
		return repository.save(receipt);
	}
	
	@Override
	public Receipt update(Receipt receipt) {
		this.readById(receipt.getId());
		
		return repository.save(receipt);
	}
	
	@Override
	public void delete(Receipt receipt) {
		repository.delete(receipt);
	}
	
}
