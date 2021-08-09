package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.controller.exception.ResourceNotFoundException;
import com.example.domain.Role;
import com.example.domain.User;

@Service
public class UserService {
	
	public User create(User user) {
		//return repository.save(user);
		return user;
	}
	
	public Role findRoleByUsernameAndPassword(String username, String password) {
		//return repository.findRolesByUsernameAndPassword(username, password).orElseThrow(?);
		if (!username.equals("test") || !password.equals("test"))
			throw new ResourceNotFoundException("User not found");
		
		return Role.DEFAULT;
	}
	
}
