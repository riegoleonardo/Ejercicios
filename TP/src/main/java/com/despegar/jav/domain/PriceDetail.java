package com.despegar.jav.domain;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceDetail {
	
//	private String currency;
//	@JsonProperty("adult_base")
//	private BigDecimal adultBase;
	private BigDecimal total;

//	@JsonCreator
//	public PriceDetail(String currency, BigDecimal adultBase, BigDecimal total) {
//		this.currency = currency;
//		this.adultBase = adultBase;
//		this.total = total;
//	}
	
	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

//	public String getCurrency() {
//		return currency;
//	}
//
//	public void setCurrency(String currency) {
//		this.currency = currency;
//	}
//
//	public BigDecimal getAdultBase() {
//		return adultBase;
//	}
//
//	public void setAdultBase(BigDecimal adultBase) {
//		this.adultBase = adultBase;
//	}
	
	
}
