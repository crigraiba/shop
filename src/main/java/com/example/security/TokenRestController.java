package com.example.security;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenRestController {
	
	@Autowired
	private TokenService service;

	@GetMapping("/anon")
	public String helloAnon() {
		return "Hello Anon!";
	}

	@GetMapping("/default")
	public String helloDefault() {
		return "Hello Default!";
	}
	
	@GetMapping("/admin")
	public String helloAdmin() {
		return "Hello Admin!";
	}
	
	@PostMapping("/login")
	public Map<String, String> login(@RequestBody Map<String, String> login) {
		return service.login(login);
	}
	
}
