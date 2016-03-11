package com.despegar.jav.error;

public class MissingParametersError {
	
	private String errorMenssage;
	
	public MissingParametersError() {
		errorMenssage = "One or more parameters it's missing";
	}

	public String getErrorMenssage() {
		return errorMenssage;
	}

	public void setErrorMenssage(String errorMenssage) {
		this.errorMenssage = errorMenssage;
	}
	
	
}
