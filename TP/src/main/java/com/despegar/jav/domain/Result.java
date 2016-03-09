package com.despegar.jav.domain;

import java.math.BigDecimal;
import java.util.List;

public class Result {
	
	private BigDecimal moneyLeft;
	private List<Destination> destinationsTaken;
	
	public BigDecimal getWallet() {
		return moneyLeft;
	}
	public void setWalley(BigDecimal moneyLeft) {
		this.moneyLeft = moneyLeft;
	}
	public List<Destination> getDestinations() {
		return destinationsTaken;
	}
	public void setDestinations(List<Destination> destinationsTaken) {
		this.destinationsTaken = destinationsTaken;
	}
	
	
}
