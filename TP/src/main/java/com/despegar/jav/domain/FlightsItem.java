package com.despegar.jav.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FlightsItem {

	private List<Items> items;
//	@JsonProperty("paging")
//	private Paging paging;

	// public FlightsItem(List<Items> items, Paging paging) {
	// this.items = items;
	// this.paging = paging;
	// }

//	public Paging getPaging() {
//		return paging;
//	}
//
//	public void setPaging(Paging paging) {
//		this.paging = paging;
//	}

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}
}
