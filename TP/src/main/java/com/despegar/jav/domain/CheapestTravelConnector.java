package com.despegar.jav.domain;


import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.despegar.jav.App;
import com.despegar.jav.domain.Travel;
import com.despegar.jav.domain.HttpRequestService;
import com.despegar.jav.serializers.DestinationDeserializer;

public class CheapestTravelConnector {

	public HttpRequestService requestService;
	public DestinationDeserializer destinationtDeserializer;
	public static HashMap<String, String> CITY_COUNTRY = new HashMap<String, String>();
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	public CheapestTravelConnector(HttpRequestService requestService, DestinationDeserializer flightDeserializer) {
		this.requestService = requestService;
		this.destinationtDeserializer = flightDeserializer;

		CITY_COUNTRY.put("BUE", "AR");
		CITY_COUNTRY.put("BRC", "AR");
		CITY_COUNTRY.put("IGR", "AR");
		CITY_COUNTRY.put("COR", "AR");
		CITY_COUNTRY.put("MDZ", "AR");
		CITY_COUNTRY.put("FTE", "AR");
		CITY_COUNTRY.put("BUE", "AR");
		CITY_COUNTRY.put("USH", "AR");
		CITY_COUNTRY.put("EZE", "AR");

		CITY_COUNTRY.put("BSB", "BR");
		CITY_COUNTRY.put("CWB", "BR");
		CITY_COUNTRY.put("SAO", "BR");
		CITY_COUNTRY.put("SSA", "BR");
		CITY_COUNTRY.put("REC", "BR");
		CITY_COUNTRY.put("RIO", "BR");
		CITY_COUNTRY.put("FOR", "BR");
		CITY_COUNTRY.put("POA", "BR");
		CITY_COUNTRY.put("MCZ", "BR");
		CITY_COUNTRY.put("FLN", "BR");
		CITY_COUNTRY.put("NAT", "BR");
		CITY_COUNTRY.put("GRU", "BR");
		CITY_COUNTRY.put("BPS", "BR");
		CITY_COUNTRY.put("JPA", "BR");
		CITY_COUNTRY.put("AJU", "BR");
		CITY_COUNTRY.put("BHZ", "BR");

		CITY_COUNTRY.put("SCL", "CL");
		CITY_COUNTRY.put("IQQ", "CL");

		CITY_COUNTRY.put("MEX", "MX");
		CITY_COUNTRY.put("CUN", "MX");

		// MEXICO
		CITY_COUNTRY.put("MEX", "MX");
		CITY_COUNTRY.put("CUN", "MX");

		// PERU
		CITY_COUNTRY.put("LIM", "PE");
		CITY_COUNTRY.put("CUZ", "PE");
		CITY_COUNTRY.put("PIU", "PE");

		// USA
		CITY_COUNTRY.put("MIA", "US");
		CITY_COUNTRY.put("ORL", "US");
		CITY_COUNTRY.put("NYC", "US");

		// ESPAÑA
		CITY_COUNTRY.put("MAD", "ES");
		CITY_COUNTRY.put("BCN", "ES");

		// ITALIA
		CITY_COUNTRY.put("ROM", "IT");

		// REP-DOMINICANA
		CITY_COUNTRY.put("PUJ", "DO");

		// COLOMBIA
		CITY_COUNTRY.put("BOG", "CO");
		CITY_COUNTRY.put("CTG", "CO");
		CITY_COUNTRY.put("ADZ", "CO");
		CITY_COUNTRY.put("SMR", "CO");
		CITY_COUNTRY.put("MDE", "CO");

		// PORTUGAL
		CITY_COUNTRY.put("LIS", "PT");

		// PANAMA
		CITY_COUNTRY.put("PTY", "PA");
	}

	public Travel getCheapestTravel(String from, String to) {
		String url = "http://backoffice.despegar.com/v3/flights/search-stats/cheapest-itineraries?channel=site&cheapest_criteria=total&search_type=roundtrip&offset=0&limit=1&currency=USD&country="
				+ CITY_COUNTRY.get(from) + "&from=" + from + "&to=" + to;
		String json = requestService.getFlightInformation(url);
		Travel cheapestFlight = destinationtDeserializer.getFlightToJason(json, CITY_COUNTRY.get(from), from, to);
		return cheapestFlight;
	}

}
