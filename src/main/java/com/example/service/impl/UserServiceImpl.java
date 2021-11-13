package com.example.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.exception.ResourceNotFoundException;
import com.example.domain.ERole;
import com.example.domain.User;
import com.example.repository.IUserRepository;
import com.example.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private IUserRepository repository;
	
	@Override
	public List<User> read() {
		return repository.findAll();
	}
	
	@Override
	public User readById(UUID id) {
		return repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " doesn't exist"));
	}
	
	@Override
	public User readByEmailAndPassword(String email, String password) {	
		return repository.findByEmailAndPassword(email, password)
			.orElseThrow(() -> new ResourceNotFoundException("User with email: " + email + " and password: " + password + " doesn't exist"));
	}
	
	@Override
	public User create(User user, ERole role) {
		user.setRole(role);
		return repository.save(user);
	}
	
	@Override
	public User update(User user) {
		this.readById(user.getId());
		
		return repository.save(user);
	}
	
	@Override
	public void delete(User user) {
		repository.delete(user);
	}
	
}
