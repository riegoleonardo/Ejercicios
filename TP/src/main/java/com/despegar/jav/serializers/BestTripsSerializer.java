package com.despegar.jav.serializers;

import org.springframework.beans.factory.annotation.Required;

import com.despegar.jav.domain.BestTrips;
import com.despegar.jav.json.JsonFactory;

public class BestTripsSerializer {
	
	private JsonFactory jsonFactory;
	
	public BestTripsSerializer(JsonFactory jsonFactory) {
		this.jsonFactory = jsonFactory;
	}

	public JsonFactory getJsonFactory() {
		return jsonFactory;
	}


	public void setJsonFactory(JsonFactory jsonFactory) {
		this.jsonFactory = jsonFactory;
	}

	public String serialize(BestTrips bestTrips) {
		return jsonFactory.toJson(bestTrips);
	}


	
	

}
