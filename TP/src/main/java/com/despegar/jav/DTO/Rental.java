package com.despegar.jav.DTO;

import java.math.BigDecimal;

public class Rental {

	private String title;
	private BigDecimal price;

	public Rental(BigDecimal price, String title) {
		this.price = price;
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
