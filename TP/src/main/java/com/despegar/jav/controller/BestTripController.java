package com.despegar.jav.controller;


import java.math.BigDecimal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.despegar.jav.domain.BestTrips;
import com.despegar.jav.domain.Result;
import com.despegar.jav.json.JsonFactory;
import com.despegar.jav.serializers.BestTripsSerializer;

@RequestMapping("/")
public class BestTripController {
	
	private BestTrips bestTrips;
	private BestTripsSerializer bestTripsSerializer;
	
	
//	@RequestMapping(value = "/prueba")
//	@ResponseBody
//	public String hello() {
//		return "Hello World";
//	}
	
	
	public BestTripController (BestTrips bestTrips, BestTripsSerializer bestTripsSerializer) {
		this.bestTrips = bestTrips;
		this.bestTripsSerializer = bestTripsSerializer;
	}
	
//	@RequestMapping(value = "/hello-world", method = {RequestMethod.GET, RequestMethod.POST})
//	@ResponseBody
//	public String hello() {
//		return "Hello World!\n";
//	}
//	
	@RequestMapping(value = "/best-trip")
	@ResponseBody
	public Result getBestTrips(
		@RequestParam(value = "from", required = true) String from,
		@RequestParam(value = "money", required = true) BigDecimal money) {
		
	    bestTrips.setBestTrips(from, money);
		return bestTrips.result();
	}
}
