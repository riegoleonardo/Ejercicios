package com.despegar.jav.domain;

import java.math.BigDecimal;
import java.util.List;

import com.despegar.jav.connector.ServiceConnector;
import com.despegar.jav.example.TopRoute;

public class CheapestDestinationsObtainer {

	private ServiceConnector serviceConnector;
	private PossibleRoutesCalculator possibleRoutesCalculator;

	public CheapestDestinationsObtainer(ServiceConnector serviceConnector,
			PossibleRoutesCalculator possibleRoutesCalculator) {
		this.serviceConnector = serviceConnector;
		this.possibleRoutesCalculator = possibleRoutesCalculator;
	}

	public ServiceConnector getServiceConnector() {
		return serviceConnector;
	}

	public void setPossibleRoutesCalculator(PossibleRoutesCalculator possibleRoutesCalculator) {
		this.possibleRoutesCalculator = possibleRoutesCalculator;
	}

	public PossibleRoutesCalculator getPossibleRoutesCalculator() {
		return possibleRoutesCalculator;
	}

	public void setServiceConnector(ServiceConnector serviceConnector) {
		this.serviceConnector = serviceConnector;
	}

	public void calculateCheapestDestinations(User user) {
		String actualCity = user.getFrom();
		Boolean insufficientFunds = ((user.getWallet().compareTo(BigDecimal.valueOf(0)) == -1)
				&& (user.getWallet().compareTo(BigDecimal.valueOf(0)) == 0));
		while ((!insufficientFunds)) {
			Destination cheapestDestination = this.getCheapestDestination(user, actualCity);
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

	public Destination getCheapestDestination(User user, String actualCity) {
		List<TopRoute> possibleDestinations = possibleRoutesCalculator.getPossibleDestinations(actualCity);
		BigDecimal lowestPrice = BigDecimal.valueOf(999999999);
		Destination cheapestDestination = null;
		for (TopRoute aRoute : possibleDestinations) {
			Destination aDestination = serviceConnector.getCheapestDestination(aRoute.getFrom(),
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
