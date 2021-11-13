package com.example.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.exception.ResourceNotFoundException;
import com.example.domain.Product;
import com.example.repository.IProductRepository;
import com.example.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private IProductRepository repository;
	
	@Override
	public List<Product> read() {
		return repository.findAll();
	}
	
	@Override
	public Product readById(UUID id) {
		return repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Product with id: " + id + " doesn't exist"));
	}
	
	@Override
	public Product create(Product product) {
		return repository.save(product);
	}
	
	@Override
	public Product update(Product product) {
		this.readById(product.getId());
		
		return repository.save(product);
	}
	
	@Override
	public void delete(Product product) {
		repository.delete(product);
	}
	
}
