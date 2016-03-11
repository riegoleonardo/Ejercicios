package com.despegar.jav.domain;

import java.math.BigDecimal;

public class BestTrips {

	private CheapestDestinationsObtainer cheapestDestinationsObtainer;

	public BestTrips(CheapestDestinationsObtainer cheapestDestinationsObtainer) {
		this.cheapestDestinationsObtainer = cheapestDestinationsObtainer;
	}

	public BestTrips() {
	}

	public TripDTO setBestTrips(String from, BigDecimal money) {
		User aUser = new User(money, from);
		cheapestDestinationsObtainer.calculateCheapestDestinations(aUser);
		TripDTO aTrip = new TripDTO();
		aTrip.setWallet(aUser.getWallet());
		aTrip.setDestinations(aUser.getVisitedDestinations());
		return aTrip;
	}
}
