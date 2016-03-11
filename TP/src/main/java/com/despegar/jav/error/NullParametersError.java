package com.despegar.jav.error;

public class NullParametersError {
	
	private String errorMenssage;
	
	public NullParametersError() {
		errorMenssage = "One or more parameters it's empty";
	}

	public String getErrorMenssage() {
		return errorMenssage;
	}

	public void setErrorMenssage(String errorMenssage) {
		this.errorMenssage = errorMenssage;
	}
	
}
