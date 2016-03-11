package com.despegar.jav.domain;

public class ReadServiceException extends RuntimeException {
	
	public ReadServiceException(String message) {
		super(message);
	}
	
	public ReadServiceException(String message, Exception e) {
		super(message, e);
	}
}
