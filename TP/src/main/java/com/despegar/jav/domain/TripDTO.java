package com.despegar.jav.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.despegar.jav.DTO.Destinations;

public class TripDTO {
	
	private BigDecimal moneyLeft;
	private List<Destinations> destinationsTaken = new ArrayList<Destinations>();
	
	public BigDecimal getWallet() {
		return moneyLeft;
	}
	public void setWallet(BigDecimal moneyLeft) {
		this.moneyLeft = moneyLeft;
	}
	public List<Destinations> getDestinations() {
		return destinationsTaken;
	}
	public void setDestinations(List<Destination> list) {
		for (Destination aDestination : list) {
			destinationsTaken.add(new Destinations(aDestination));
		}
	}
	
	
}
