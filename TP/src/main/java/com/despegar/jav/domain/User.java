package com.despegar.jav.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class User {
	
	private BigDecimal wallet;
	private String from;
	private List<Travel> visitedDestinations = new ArrayList<Travel>();
	
	public User(BigDecimal money, String aCity) {
		wallet = money;
		from = aCity;
	}
	
	public User() {
	}

	public BigDecimal getWallet() {
		return wallet;
	}

	public void setWallet(BigDecimal wallet) {
		this.wallet = wallet;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public List<Travel> getVisitedDestinations() {
		return visitedDestinations;
	}

	public void setVisitedDestinations(List<Travel> visitedDestinations) {
		this.visitedDestinations = visitedDestinations;
	}

	public void addDestination(Travel aDestination) {
			visitedDestinations.add(aDestination);
			wallet = wallet.subtract(aDestination.getAmount());	
	}
	
	public boolean notVisitedDestination(String actualCity) {
		if(!(visitedDestinations.isEmpty())){
			Boolean visitedDestination = false;
			Integer i = 0;
			while ((!visitedDestination) && (i < visitedDestinations.size())) {
				visitedDestination = (visitedDestinations.get(i).getCityCode().equals(actualCity));
				i++;
			}
			return ((!visitedDestination) && (!actualCity.equals(from)));
		} else {
			return(!actualCity.equals(from));
		}	
	}


	
}
