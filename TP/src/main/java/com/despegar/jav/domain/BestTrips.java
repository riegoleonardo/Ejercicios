package com.despegar.jav.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.despegar.jav.example.TopRoute;
import com.despegar.jav.example.TopRoutesReader;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class BestTrips {

	private TopRoutesReader topRoutesReader;
	private CheapestDestination cheapestDestinationObtainer;
	private List<Destination> destinationsTaken = new ArrayList<Destination>();
	private BigDecimal moneyLeft;
	private String initialCity;

	public BestTrips(TopRoutesReader topRoutesReader, CheapestDestination cheapestDestination) {
		this.topRoutesReader = topRoutesReader;
		this.cheapestDestinationObtainer = cheapestDestination;
		
	}
	
	
	public TopRoutesReader getTopRoutesReader() {
		return topRoutesReader;
	}


	public void setTopRoutesReader(TopRoutesReader topRoutesReader) {
		this.topRoutesReader = topRoutesReader;
	}


	public CheapestDestination getCheapestDestinationObtainer() {
		return cheapestDestinationObtainer;
	}

	
	public void setCheapestDestinationObtainer(CheapestDestination cheapestDestinationObtainer) {
		this.cheapestDestinationObtainer = cheapestDestinationObtainer;
	}


	public List<Destination> getDestinationsTaken() {
		return destinationsTaken;
	}
	
	public void setDestinationsTaken(List<Destination> aListOfDestinations) {
		destinationsTaken = aListOfDestinations;
	}

	
	public String getInitialCity() {
		return initialCity;
	}


	public BestTrips() {
	}
	

	public BigDecimal getMoneyLeft() {
		return moneyLeft;
	}
	
	
	public void setInitialCity(String aCity) {
		initialCity = aCity;
	}
	
	
	public void setBestTrips(String from, BigDecimal money) {
		String actualCity = from;
		moneyLeft = money;
		Boolean insufficientFunds = ((moneyLeft.compareTo(BigDecimal.valueOf(0)) == -1)
				&& (moneyLeft.compareTo(BigDecimal.valueOf(0)) == 0));
		while ((!insufficientFunds)) {
			Destination cheapestDestination = this.getCheapestDestination(actualCity);
			if(cheapestDestination != null) {
				if (cheapestDestination.getAmount().compareTo(moneyLeft) == -1) {
					destinationsTaken.add(cheapestDestination);
					moneyLeft = moneyLeft.subtract(cheapestDestination.getAmount());
					actualCity = cheapestDestination.getCityCode();
				} else {
					insufficientFunds = true;
				}
			} else {
				insufficientFunds = true;
			}
		} 
	}
	
	public void setMoneyLeft(BigDecimal money) {
		moneyLeft = money;
	}
	

	public Destination getCheapestDestination(String actualCity) {
		List<TopRoute> possibleDestinations = this.getPossibleDestinations(actualCity);
		BigDecimal lowestPrice = BigDecimal.valueOf(999999999);
		Destination cheapestDestination = null;
		for (TopRoute aRoute : possibleDestinations) {
			Destination aDestination = cheapestDestinationObtainer.getCheapestDestination(aRoute.getFrom(), aRoute.getTo());
			if ((aDestination.getAmount().compareTo(lowestPrice) == -1) && this.notVisitedDestination(aRoute.getTo())) {
				lowestPrice = aDestination.getAmount();
				cheapestDestination = aDestination;
			}
		}
		return cheapestDestination;
	}

	public boolean notVisitedDestination(String actualCity) {
		if(!(destinationsTaken.isEmpty())){
			Boolean visitedDestination = false;
			Integer i = 0;
			while ((!visitedDestination) && (i < destinationsTaken.size())) {
				visitedDestination = (destinationsTaken.get(i).getCityCode().equals(actualCity));
				i++;
			}
			return ((!visitedDestination) && (!actualCity.equals(initialCity)));
		} else {
			return(actualCity != initialCity);
		}
		
		
	}

	
	public List<TopRoute> getPossibleDestinations(String actualCity) {
		List<TopRoute> topRoutesCollection = topRoutesReader.getTopRoutes();
		ArrayList<TopRoute> possibleDestinations = new ArrayList<TopRoute>();
		for (TopRoute aRoute : topRoutesCollection) {
			if (aRoute.getFrom().equals(actualCity)) {
				possibleDestinations.add(aRoute);
			}
		}
		return possibleDestinations;
	}


	public Result result() {
		Result result = new Result();
		result.setWalley(moneyLeft);
		result.setDestinations(destinationsTaken);
		return result;
	}

}
