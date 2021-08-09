package com.example.configuration;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class Filter extends OncePerRequestFilter {
	
	private final String
		HEADER = "Authorization",
		PREFIX = "Bearer ",
		SECRET = "mySecretKey";
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) 
		throws ServletException, IOException {
		//try {
			if (this.isTokenValid(request, response)) {
				Claims claims = this.getClaims(request);
				
				if (claims.get("authorities") != null)
					this.setUpSpringAuthentication(claims);
				else
					SecurityContextHolder.clearContext();
			} else
				SecurityContextHolder.clearContext();
			
			chain.doFilter(request, response);
		/*} catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
		}*/
	}
	
	private boolean isTokenValid(HttpServletRequest request, HttpServletResponse response) {
		String header = request.getHeader(HEADER);
		
		if (header == null || !header.startsWith(PREFIX))
			return false;
		
		return true;
	}
	
	private Claims getClaims(HttpServletRequest request) {
		String token = request.getHeader(HEADER).replace(PREFIX, "");
		
		return Jwts
			.parser()
			.setSigningKey(SECRET.getBytes())
			.parseClaimsJws(token)
			.getBody();
	}
	
	private void setUpSpringAuthentication(Claims claims) {
		List<String> authorities = Arrays.asList(claims
			.get("authorities")
			.toString()
			.split(","));
		
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
			claims
				.getSubject(),
			null,
			authorities
				.stream()
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}
	
}
