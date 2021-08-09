package com.example.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;

@RestControllerAdvice
public class GlobalRestControllerAdvice {
	
	@ExceptionHandler({ExpiredJwtException.class, UnsupportedJwtException.class, MalformedJwtException.class})
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public ErrorMessage handleException(JwtException e) {
		return new ErrorMessage(e.getMessage());
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessage handleException(ResourceNotFoundException e) {
		return new ErrorMessage(e.getMessage());
	}
	
}
