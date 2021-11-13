package com.example.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.exception.ResourceNotFoundException;
import com.example.domain.Address;
import com.example.repository.IAddressRepository;
import com.example.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private IAddressRepository repository;
	
	@Override
	public List<Address> read() {
		return repository.findAll();
	}
	
	@Override
	public Address readById(UUID id) {
		return repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Address with id: " + id + " doesn't exist"));
	}
	
	@Override
	public Address create(Address address) {
		return repository.save(address);
	}
	
	@Override
	public Address update(Address address) {
		this.readById(address.getId());
		
		return repository.save(address);
	}
	
	@Override
	public void delete(Address address) {
		repository.delete(address);
	}
	
}
