package com.example.service;

import java.util.List;
import java.util.UUID;

import com.example.domain.ERole;
import com.example.domain.User;

public interface UserService {
	
	public List<User> read();
	
	public User readById(UUID id);
	
	public User readByEmailAndPassword(String email, String password);
	
	public User create(User user, ERole role);
	
	public User update(User user);
	
	public void delete(User user);
	
}
