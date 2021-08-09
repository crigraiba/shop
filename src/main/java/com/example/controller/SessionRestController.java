package com.example.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Role;
import com.example.domain.User;
import com.example.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/users/sessions")
public class SessionRestController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	private String secretKey = "mySecretKey";
	
	@PostMapping // login - authentication and authorization
	public User create(@RequestBody User user) {
		// Authentication:
		String username = user.getUsername();
		String password = user.getPassword();
		
		System.err.println("username=" + username + ", password=" + password); // FIXME
		
		/*Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password)); // throws JwtException
		SecurityContextHolder.getContext().setAuthentication(authentication);*/
		
		// Authorization:
		Role role = service.findRoleByUsernameAndPassword(username, password);
		user.setRole(role);
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + role));

		System.err.println("role=" + role); // FIXME
		System.err.println("authorities=" + authorities.toString()); // FIXME
		
		String token = this.generateToken(username, authorities);
		user.setToken(token);
		
		return user;
	}
	
	private String generateToken(String username, List<GrantedAuthority> authorities) {
		String token = Jwts
			.builder()
			.setSubject(username)
			.claim(
				"authorities",
				authorities
					.stream()
					.map(GrantedAuthority::getAuthority)
					.collect(Collectors.toList()))
			.setIssuedAt(new Date(System.currentTimeMillis()))
			.setExpiration(new Date(System.currentTimeMillis() + 600000))
			.signWith(
				SignatureAlgorithm.HS512,
				secretKey.getBytes())
			.compact();
		
		return "Bearer " + token;
	}
	
}
