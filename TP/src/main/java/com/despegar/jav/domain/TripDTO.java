package com.despegar.jav.domain;

import java.math.BigDecimal;
import java.util.List;

public class TripDTO {
	
	private BigDecimal moneyLeft;
	private List<Travel> destinationsTaken;
	
	public BigDecimal getWallet() {
		return moneyLeft;
	}
	public void setWallet(BigDecimal moneyLeft) {
		this.moneyLeft = moneyLeft;
	}
	public List<Travel> getDestinations() {
		return destinationsTaken;
	}
	public void setDestinations(List<Travel> destinationsTaken) {
		this.destinationsTaken = destinationsTaken;
	}
	
	
}
