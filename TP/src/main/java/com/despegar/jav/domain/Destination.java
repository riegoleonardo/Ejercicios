package com.despegar.jav.domain;

import java.math.BigDecimal;

import com.despegar.jav.DTO.Hotel;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Destination {
	
	private Hotel hotel;
	private Travel travel;

	public Destination(Travel travel, Hotel hotel) {
		this.travel = travel;
		this.hotel = hotel;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Travel getTravel() {
		return travel;
	}

	public void setTravel(Travel travel) {
		this.travel = travel;
	}
	
	@JsonIgnore
	public BigDecimal getAmount() {
		return travel.getAmount().add(hotel.getPrice());
	}
	
	public String getCityCode() {
		return travel.getCityCode();
	}
	
	

}
