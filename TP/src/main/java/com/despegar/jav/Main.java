package com.despegar.jav;

import com.despegar.jav.DTO.Hotel;

import java.io.InputStreamReader;

import java.math.BigDecimal;
import java.util.List;

import com.despegar.jav.DTO.Hotel;
import com.despegar.jav.domain.BestTrips;
import com.despegar.jav.domain.CheapestTravelConnector;
import com.despegar.jav.domain.FlightsItem;
import com.despegar.jav.domain.HttpRequestService;
import com.despegar.jav.domain.Items;
import com.despegar.jav.domain.PossibleRoutesCalculator;
import com.despegar.jav.domain.PriceDetail;
import com.despegar.jav.example.TopRoute;
import com.despegar.jav.example.TopRoutesReader;
import com.despegar.jav.json.JsonFactory;
import com.despegar.jav.serializers.DestinationDeserializer;
import com.despegar.jav.serializers.HotelsDeserializer;
import com.despesgar.jav.connector.HotelsConnector;
import com.fasterxml.jackson.core.type.TypeReference;

public class Main {
	public static void main(String args[]) {
		
		JsonFactory jsonFactory = new JsonFactory();
		HttpRequestService cheapes = new HttpRequestService();
//		String json = cheapes.getFlightInformation("http://backoffice.despegar.com/v3/flights/search-stats/cheapest-itineraries?channel=site&cheapest_criteria=total&search_type=roundtrip&offset=0&limit=1&currency=USD&country=AR&from=BUE&to=MIA");
//		FlightsItem anItem = jsonFactory.fromJson(json, new TypeReference<FlightsItem>(){});
//		List<Items> listOfItems = anItem.getItems();
//		Items anotherItem = listOfItems.get(0);
//		PriceDetail aPrice = anotherItem.getPriceDetail();
//		System.out.println(aPrice.getTotal());
//		System.out.println(jsonFactory.toJson(aPrice));
//		
//		 BestTrips bestTrips = new BestTrips(new TopRoutesReader(), new CheapestDestinationConnector(cheapes, new DestinationDeserializer(jsonFactory)));
//		 CheapestDestinationConnector lala = new CheapestDestinationConnector(cheapes, new DestinationDeserializer(jsonFactory));
//		 TopRoutesReader topRoutesReader = new TopRoutesReader();
//		
//		 System.out.println(jsonFactory.toJson(bestTrips.getCheapestDestination("BUE")));
//		 bestTrips.setBestTrips("BUE", BigDecimal.valueOf(1000));
//	     
//
//	     System.out.println(bestTrips.getMoneyLeft());
//		
//		TopRoutesReader reader = new TopRoutesReader();
//		PossibleRoutesCalculator possibleRoutes = new PossibleRoutesCalculator(reader);
//		List<TopRoute> lista = possibleRoutes.getPossibleDestinations("BUE");
//		System.out.println(lista != null);
		//BestTrips bestTrips = new BestTrips(new TopRoutesReader(), new CheapestDestination(cheap,));
		//bestTrips.setBestTrips("BUE", BigDecimal.valueOf(1000));
		
		HotelsDeserializer deserializer = new HotelsDeserializer(jsonFactory);
		HotelsConnector conector = new HotelsConnector(cheapes, deserializer);
		List<Hotel> collecion = conector.getCollectionOfHotels("RIO");
		
		
		for (Hotel aHotel : collecion) {
			System.out.println(aHotel.getTitle());
		}
		
	}
}
