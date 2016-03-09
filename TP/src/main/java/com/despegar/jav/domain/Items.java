package com.despegar.jav.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Items {

	private String id;
	private String airline;
	private Integer stops;
	@JsonProperty("departure_date")
	private String departureDate;
	@JsonProperty("return_date")
	private String returnDate;
	@JsonProperty("price_detail")
	private PriceDetail priceDetail;
	
	
	public Items() {
		
	}
	
	public PriceDetail getPriceDetail() {
		return priceDetail;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public int getStops() {
		return stops;
	}

	public void setStops(int stops) {
		this.stops = stops;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public void setPriceDetail(PriceDetail priceDetail) {
		this.priceDetail = priceDetail;
	}
	
	
}
