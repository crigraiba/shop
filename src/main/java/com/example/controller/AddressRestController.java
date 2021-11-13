package com.example.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Address;
import com.example.service.impl.AddressServiceImpl;

@RestController
@RequestMapping("/addresses")
public class AddressRestController {
	
	@Autowired
	private AddressServiceImpl service;
	
	@GetMapping
	@PreAuthorize("hasAnyRole('EMPLOYEE', 'ADMIN')")
	public List<Address> read() {
		return service.read();
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAnyRole('CLIENT', 'EMPLOYEE', 'ADMIN')")
	public Address readById(@PathVariable UUID id) {
		return service.readById(id);
	}
	
}
