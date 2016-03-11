package com.despegar.jav.error;

public class InternalError {

	private String errorMessage;
	
	public InternalError() {
		setErrorMessage("There was an error with the application, please try again later");
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
