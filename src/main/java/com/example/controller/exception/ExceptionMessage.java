package com.example.controller.exception;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExceptionMessage {
	
	@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime timestamp;
	private int status;
	private String error;
	private String message;
	
	public ExceptionMessage(LocalDateTime timestamp, String message) {
		this.timestamp = timestamp;
		this.message = message;
	}
	
	public ExceptionMessage(LocalDateTime timestamp, int status, String error, String message) {
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
	}
	
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public void setError(String error) {
		this.error = error;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	
	public int getStatus() {
		return status;
	}
	
	public String getError() {
		return error;
	}
	
	public String getMessage() {
		return message;
	}
	
}
