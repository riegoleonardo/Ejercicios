package com.despegar.jav.serializers;

import java.util.List;

import com.despegar.jav.domain.Destination;
import com.despegar.jav.domain.Flight;
import com.despegar.jav.domain.FlightsItem;
import com.despegar.jav.domain.Items;
import com.despegar.jav.domain.PriceDetail;
import com.despegar.jav.json.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;

public class DestinationDeserializer {

	private JsonFactory jsonFactory;

	public DestinationDeserializer(JsonFactory jsonFactory) {
		this.jsonFactory = jsonFactory;
	}

	public Destination getFlightToJason(String json, String country, String from, String to) {
		FlightsItem anItem = jsonFactory.fromJson(json, new TypeReference<FlightsItem>() {
		});
		List<Items> listOfItems = anItem.getItems();
		Items anotherItem = listOfItems.get(0);
		PriceDetail aPrice = anotherItem.getPriceDetail();
		Flight aFlight = new Flight(aPrice.getTotal(), anotherItem.getAirline());
		return new Destination(country, from, to, aFlight);
	}

}
