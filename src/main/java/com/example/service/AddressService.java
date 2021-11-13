package com.example.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.exception.ResourceNotFoundException;
import com.example.domain.Address;
import com.example.repository.IAddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private IAddressRepository repository;
	
	public List<Address> read() {
		return repository.findAll();
	}
	
	public Address readById(UUID id) {
		return repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Address with id: " + id + " doesn't exist"));
	}
	
	public Address create(Address address) {
		return repository.save(address);
	}
	
	public Address update(Address address) {
		this.readById(address.getId());
		
		return repository.save(address);
	}
	
	public void delete(Address address) {
		repository.delete(address);
	}
	
}
