package com.despegar.jav.connector;

import java.util.List;

import com.despegar.jav.DTO.Hotel;
import com.despegar.jav.domain.HttpRequestService;
import com.despegar.jav.serializers.HotelsDeserializer;

public class HotelsConnector {

	public HttpRequestService requestService;
	public HotelsDeserializer hotelsDeserializer;

	public HotelsConnector(HttpRequestService requestService, HotelsDeserializer hotelsDeserializer) {
		this.requestService = requestService;
		this.hotelsDeserializer = hotelsDeserializer;
	}

	public List<Hotel> getCollectionOfHotels(String city) {
		String url = "http://backoffice.despegar.com/v3/vr/home/ads/" + city;
		String json = requestService.getFlightInformation(url);
		return hotelsDeserializer.getHotelsToJason(json, city);
	}
}
