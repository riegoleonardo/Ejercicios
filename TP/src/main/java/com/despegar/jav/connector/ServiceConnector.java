package com.despegar.jav.connector;

import java.math.BigDecimal;
import java.util.List;

import com.despegar.jav.domain.Destination;

import com.despegar.jav.DTO.Hotel;

import com.despegar.jav.domain.Travel;

public class ServiceConnector {
	
	private CheapestTravelConnector cheapestTravelConnector;
	private HotelsConnector hotelConnector;
	
	public ServiceConnector(){
		
	}
	
	public ServiceConnector(CheapestTravelConnector cheapestTravelConnector, HotelsConnector hotelsConnector) {
		this.cheapestTravelConnector = cheapestTravelConnector;
		this.hotelConnector = hotelsConnector;
	}
	
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
	
	public Destination getCheapestDestination(String from, String to) {
		Travel travel = cheapestTravelConnector.getCheapestTravel(from, to);
		List<Hotel> hotelCollection = hotelConnector.getCollectionOfHotels(to);
		BigDecimal cheapestPrice = BigDecimal.valueOf(999999999);
		if(!hotelCollection.isEmpty()) {
			Hotel cheapestHotel = null;
			for (Hotel aHotel : hotelCollection) {
				if (aHotel.getPrice().compareTo(cheapestPrice) == -1) {
					cheapestPrice = aHotel.getPrice();
					cheapestHotel = aHotel;
				}
			}
			return new Destination(travel, cheapestHotel);
		} else {
			return null;
		}
	}
}
