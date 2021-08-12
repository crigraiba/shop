package com.example.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.ERole;
import com.example.domain.User;
import com.example.service.UserService;

@RestController
@RequestMapping("/users")
public class UserRestController {
	
	@Autowired
	private UserService service;

	@GetMapping
	public List<User> read() {
		return service.read();
	}

	@GetMapping("/{id}")
	public User readById(@PathVariable UUID id) {
		return service.readById(id);
	}
	
	@PostMapping("/default")
	@ResponseStatus(HttpStatus.CREATED)
	public User createDefault(@RequestBody User user) {
		return service.create(user, ERole.DEFAULT);
	}
	
	@PostMapping("/admin")
	@ResponseStatus(HttpStatus.CREATED)
	public User createAdmin(@RequestBody User user) {
		return service.create(user, ERole.ADMIN);
	}
	
	@PutMapping
	public User update(@RequestBody User user) {
		return service.update(user);
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@RequestBody User user) {
		service.delete(user);
	}
	
}
