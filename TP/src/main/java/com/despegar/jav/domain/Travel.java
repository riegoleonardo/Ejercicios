package com.despegar.jav.domain;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Travel {

	private String country;
	private String cityFrom;
	private String cityTo;
	private Flight flight;

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Travel(String aCountry, String from, String to, Flight aFlight) {
		country = aCountry;
		cityFrom = from;
		cityTo = to;
		flight = aFlight;
	}

	public Travel() {
	}
	
	@JsonIgnore
	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}

	@JsonIgnore
	public String getCityFrom() {
		return cityFrom;
	}


	public void setCityFrom(String cityFrom) {
		this.cityFrom = cityFrom;
	}
	
	@JsonIgnore
	public String getCityCode() {
		return cityTo;
	}

	public void setCityCode(String cityTo) {
		this.cityTo = cityTo;
	}

	@JsonIgnore
	public BigDecimal getAmount() {
		return flight.getAmount();
	}


	public void setAmount(BigDecimal price) {
		this.flight.setAmount(price);;
	}
	
	public String getAirline() {
		return flight.getAirline();
	}
}
