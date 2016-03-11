package com.despegar.jav.serializers;

import java.util.List;

import com.despegar.jav.DTO.Hotel;
import com.despegar.jav.domain.Travel;
import com.despegar.jav.domain.Flight;
import com.despegar.jav.domain.FlightsItem;
import com.despegar.jav.domain.Items;
import com.despegar.jav.domain.PriceDetail;
import com.despegar.jav.json.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;

public class HotelsDeserializer {

	private JsonFactory jsonFactory;

	public HotelsDeserializer(JsonFactory jsonFactory) {
		this.jsonFactory = jsonFactory;
	}

	public List<Hotel> getHotelsToJason(String json, String city) {
		return jsonFactory.fromJson(json, new TypeReference<List<Hotel>>() {
		});
		
	}
}
