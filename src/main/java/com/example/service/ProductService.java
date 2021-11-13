package com.example.service;

import java.util.List;
import java.util.UUID;

import com.example.domain.Product;

public interface ProductService {
	
	public List<Product> read();
	
	public Product readById(UUID id);
	
	public Product create(Product receipt);
	
	public Product update(Product receipt);
	
	public void delete(Product receipt);
	
}
