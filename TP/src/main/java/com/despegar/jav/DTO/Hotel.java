package com.despegar.jav.DTO;

import java.math.BigDecimal;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Hotel {
	
	public Hotel() {
		
	}

	private String title;
	@JsonProperty("prices")
	private Map<String,  BigDecimal> prices;
	@JsonProperty("city_code")
	private String CityCode;
	
	public Hotel(String title, Map<String, BigDecimal> prices) {
		this.title = title;
		this.prices = prices;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Map<String, BigDecimal> getPrices() {
		return prices;
	}
	public void setPrices(Map<String, BigDecimal> prices) {
		this.prices = prices;
	}
	public String getCityCode() {
		return CityCode;
	}
	public void setCityCode(String cityCode) {
		CityCode = cityCode;
	}
	
	
}
