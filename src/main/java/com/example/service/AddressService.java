package com.example.service;

import java.util.List;
import java.util.UUID;

import com.example.domain.Address;

public interface AddressService {
	
	public List<Address> read();
	
	public Address readById(UUID id);
	
	public Address create(Address receipt);
	
	public Address update(Address receipt);
	
	public void delete(Address receipt);
	
}
