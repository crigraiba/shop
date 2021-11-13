package com.example.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.example.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserRestController {
	
	@Autowired
	private UserServiceImpl service;
	
	@GetMapping
	@PreAuthorize("hasAnyRole('EMPLOYEE', 'ADMIN')")
	public List<User> read() {
		return service.read();
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAnyRole('EMPLOYEE', 'ADMIN')")
	public User readById(@PathVariable UUID id) {
		return service.readById(id);
	}
	
	@PostMapping("/client")
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("permitAll()")
	public User createClient(@RequestBody User user) {
		return service.create(user, ERole.CLIENT);
	}
	
	@PostMapping("/employee")
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasRole('ADMIN')")
	public User createEmployee(@RequestBody User user) {
		return service.create(user, ERole.EMPLOYEE);
	}
	
	@PostMapping("/admin")
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasRole('ADMIN')")
	public User createAdmin(@RequestBody User user) {
		return service.create(user, ERole.ADMIN);
	}
	
	@PutMapping
	@PreAuthorize("hasRole('ADMIN')")
	public User update(@RequestBody User user) {
		return service.update(user);
	}
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasRole('ADMIN')")
	public void delete(@RequestBody User user) {
		service.delete(user);
	}
	
}
