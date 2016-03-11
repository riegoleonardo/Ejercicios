package com.despesgar.jav.connector;

import com.despegar.jav.domain.CheapestTravelConnector;
import com.despegar.jav.domain.Travel;

public class ServiceConnector {
	
	private CheapestTravelConnector cheapestTravelConnector;
	private HotelsConnector hotelConnector;
	
	
	public CheapestTravelConnector getCheapestDestinationConnector() {
		return cheapestTravelConnector;
	}
	public void setCheapestDestinationConnector(CheapestTravelConnector cheapestTravelConnector) {
		this.cheapestTravelConnector = cheapestTravelConnector;
	}
	public HotelsConnector getHotelConnector() {
		return hotelConnector;
	}
	public void setHotelConnector(HotelsConnector hotelConnector) {
		this.hotelConnector = hotelConnector;
	}
	
	public Travel getCheapestDestination(String from, String to) {
		cheapestTravelConnector.get
		
		return null;
	}
}
