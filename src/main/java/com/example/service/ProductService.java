package com.example.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.exception.ResourceNotFoundException;
import com.example.domain.Product;
import com.example.repository.IProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private IProductRepository repository;
	
	public List<Product> read() {
		return repository.findAll();
	}
	
	public Product readById(UUID id) {
		return repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Product with id: " + id + " doesn't exist"));
	}
	
	public Product create(Product product) {
		return repository.save(product);
	}
	
	public Product update(Product product) {
		this.readById(product.getId());
		
		return repository.save(product);
	}
	
	public void delete(Product product) {
		repository.delete(product);
	}
	
}
