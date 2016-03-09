package com.despegar.jav;

import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;

import com.despegar.jav.domain.BestTrips;
import com.despegar.jav.domain.CheapestDestination;
import com.despegar.jav.domain.FlightsItem;
import com.despegar.jav.domain.HttpRequestService;
import com.despegar.jav.domain.Items;
import com.despegar.jav.domain.PriceDetail;
import com.despegar.jav.example.TopRoute;
import com.despegar.jav.example.TopRoutesReader;
import com.despegar.jav.json.JsonFactory;
import com.despegar.jav.serializers.DestinationDeserializer;
import com.fasterxml.jackson.core.type.TypeReference;

public class Main {
	public static void main(String args[]) {
		
		JsonFactory jsonFactory = new JsonFactory();
		HttpRequestService cheapes = new HttpRequestService();
		String json = cheapes.getFlightInformation("http://backoffice.despegar.com/v3/flights/search-stats/cheapest-itineraries?channel=site&cheapest_criteria=total&search_type=roundtrip&offset=0&limit=1&currency=USD&country=AR&from=BUE&to=MIA");
		FlightsItem anItem = jsonFactory.fromJson(json, new TypeReference<FlightsItem>(){});
		List<Items> listOfItems = anItem.getItems();
		Items anotherItem = listOfItems.get(0);
		PriceDetail aPrice = anotherItem.getPriceDetail();
		System.out.println(aPrice.getTotal());
		System.out.println(jsonFactory.toJson(aPrice));
		
		 BestTrips bestTrips = new BestTrips(new TopRoutesReader(), new CheapestDestination(cheapes, new DestinationDeserializer(jsonFactory)));
		 CheapestDestination lala = new CheapestDestination(cheapes, new DestinationDeserializer(jsonFactory));
		 TopRoutesReader topRoutesReader = new TopRoutesReader();
		
		 System.out.println(jsonFactory.toJson(bestTrips.getCheapestDestination("BUE")));
		 bestTrips.setBestTrips("BUE", BigDecimal.valueOf(1000));
	     
	     System.out.println(jsonFactory.toJson(bestTrips.getDestinationTaken()));
	     System.out.println(bestTrips.getMoneyLeft());
		
		//BestTrips bestTrips = new BestTrips(new TopRoutesReader(), new CheapestDestination(cheap,));
		//bestTrips.setBestTrips("BUE", BigDecimal.valueOf(1000));
	}
}
