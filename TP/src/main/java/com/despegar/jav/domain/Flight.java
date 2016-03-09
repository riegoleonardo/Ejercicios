package com.despegar.jav.domain;

import java.math.BigDecimal;

public class Flight {
	
	private BigDecimal amount;
	private String airline;

	public Flight(BigDecimal aAmount, String aAirline) {
		amount = aAmount;
		airline = aAirline;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}
}
