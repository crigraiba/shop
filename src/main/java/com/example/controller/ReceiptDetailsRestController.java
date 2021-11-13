package com.example.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.ReceiptDetails;
import com.example.service.ReceiptDetailsService;

@RestController
@RequestMapping("/receipt-details")
public class ReceiptDetailsRestController {
	
	@Autowired
	private ReceiptDetailsService service;
	
	@GetMapping
	@PreAuthorize("hasAnyRole('EMPLOYEE', 'ADMIN')")
	public List<ReceiptDetails> read() {
		return service.read();
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAnyRole('CLIENT', 'EMPLOYEE', 'ADMIN')")
	public ReceiptDetails readById(@PathVariable UUID id) {
		return service.readById(id);
	}
	
}
