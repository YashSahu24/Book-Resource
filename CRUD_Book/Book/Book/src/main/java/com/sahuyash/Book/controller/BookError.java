package com.sahuyash.Book.controller;

public class BookError {
  
	private int status;
	private String message;
	private Long time;
	
	public BookError()
	{
		
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public BookError(int status, String message, Long time) {
		this.status = status;
		this.message = message;
		this.time = time;
	}
	
	
	
}
