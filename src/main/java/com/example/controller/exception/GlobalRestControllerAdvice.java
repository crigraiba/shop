package com.example.controller.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalRestControllerAdvice {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ExceptionMessage handleException(HttpStatus status, ResourceNotFoundException e) {
		return new ExceptionMessage(LocalDateTime.now(), status.value(), status.name(), e.getMessage());
	}
	
	@ExceptionHandler(Exception.class)
	public ExceptionMessage handleException(Exception e) {
		return new ExceptionMessage(LocalDateTime.now(), e.getClass() + ", message: " + e.getMessage() + ", toString: " + e.toString());
	}
	
}
