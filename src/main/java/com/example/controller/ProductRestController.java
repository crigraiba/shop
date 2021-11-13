package com.example.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Product;
import com.example.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductRestController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping
	@PreAuthorize("permitAll()")
	public List<Product> read() {
		return service.read();
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("permitAll()")
	public Product readById(@PathVariable UUID id) {
		return service.readById(id);
	}
	
}
