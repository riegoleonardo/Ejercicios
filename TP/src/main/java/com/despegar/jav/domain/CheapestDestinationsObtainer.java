package com.despegar.jav.domain;

import java.math.BigDecimal;
import java.util.List;

import com.despegar.jav.example.TopRoute;

public class CheapestDestinationsObtainer {

	private CheapestTravelConnector cheapestTravelConnector;
	private PossibleRoutesCalculator possibleRoutesCalculator;

	public CheapestDestinationsObtainer(CheapestTravelConnector cheapestDestinationConnector,
			PossibleRoutesCalculator possibleRoutesCalculator) {
		this.cheapestTravelConnector = cheapestDestinationConnector;
		this.possibleRoutesCalculator = possibleRoutesCalculator;
	}

	public CheapestTravelConnector getCheapestDestinationConnector() {
		return cheapestTravelConnector;
	}

	public void setPossibleRoutesCalculator(PossibleRoutesCalculator possibleRoutesCalculator) {
		this.possibleRoutesCalculator = possibleRoutesCalculator;
	}

	public PossibleRoutesCalculator getPossibleRoutesCalculator() {
		return possibleRoutesCalculator;
	}

	public void setCheapestDestinationConnector(CheapestTravelConnector cheapestDestinationConnector) {
		this.cheapestTravelConnector = cheapestDestinationConnector;
	}

	public void calculateCheapestDestinations(User user) {
		String actualCity = user.getFrom();
		Boolean insufficientFunds = ((user.getWallet().compareTo(BigDecimal.valueOf(0)) == -1)
				&& (user.getWallet().compareTo(BigDecimal.valueOf(0)) == 0));
		while ((!insufficientFunds)) {
			Travel cheapestDestination = this.getCheapestDestination(user, actualCity);
			if (cheapestDestination != null) {
				if (cheapestDestination.getAmount().compareTo(user.getWallet()) == -1) {
					user.addDestination(cheapestDestination);
					actualCity = cheapestDestination.getCityCode();
				} else {
					insufficientFunds = true;
				}
			} else {
				insufficientFunds = true;
			}
		}
	}

	public Travel getCheapestDestination(User user, String actualCity) {
		List<TopRoute> possibleDestinations = possibleRoutesCalculator.getPossibleDestinations(actualCity);
		BigDecimal lowestPrice = BigDecimal.valueOf(999999999);
		Travel cheapestDestination = null;
		for (TopRoute aRoute : possibleDestinations) {
			Travel aDestination = cheapestTravelConnector.getCheapestTravel(aRoute.getFrom(),
					aRoute.getTo());
			if(aDestination != null) {
				if ((aDestination.getAmount().compareTo(lowestPrice) == -1) && user.notVisitedDestination(aRoute.getTo())) {
					lowestPrice = aDestination.getAmount();
					cheapestDestination = aDestination;
				}
			}
		}
		return cheapestDestination;
	}

}
