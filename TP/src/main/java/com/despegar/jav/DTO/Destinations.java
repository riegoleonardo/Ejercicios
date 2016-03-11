package com.despegar.jav.DTO;

import com.despegar.jav.domain.Destination;
import com.despegar.jav.domain.Flight;

public class Destinations {

	private String cityCode;
	private Flight flight;
	private Rental rental;

	public Destinations(Destination destination) {
		cityCode = destination.getCityCode();
		flight = destination.getTravel().getFlight();
		rental = new Rental(destination.getHotel().getPrice(), destination.getHotel().getTitle());
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Rental getRental() {
		return rental;
	}

	public void setRental(Rental rental) {
		this.rental = rental;
	}

}
