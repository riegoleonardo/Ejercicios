package com.despegar.jav.domain;


import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import com.despegar.jav.example.TopRoute;
import com.despegar.jav.example.TopRoutesReader;
import com.despegar.jav.domain.Destination;
import java.math.BigDecimal;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class BestTripsTest {
	
	private TopRoutesReader topRoutesReader;
	private CheapestDestination cheapestDestinationObtainer;
	private Collection<Destination> flightsTaken;
	private BestTrips bestTrips;
	

//   @Before
//    public void setUp(){
//        topRoutesReader = new TopRoutesReader
//        cityService = mock(CityService.class);
//        tripGenerator.setCityService(cityService);
//
//        flightService = mock(FlightService.class);
//        tripGenerator.setFlightService(flightService);
//
//        hotelService= mock(HotelService.class);
//        tripGenerator.setHotelService(hotelService);
//
//        randomProvider = mock(RandomProvider.class);
//        tripGenerator.setRandomProvider(randomProvider);
//    }
	
	@Before
	public void setUp() {
		topRoutesReader = mock(TopRoutesReader.class);
		cheapestDestinationObtainer = mock(CheapestDestination.class);
		bestTrips = new BestTrips(topRoutesReader, cheapestDestinationObtainer);
		bestTrips.setInitialCity("BUE");
		bestTrips.setMoneyLeft(BigDecimal.valueOf(500));
	}
	
	@Test
	public void testSetBestTrips() {
		TopRoute route1 = mock(TopRoute.class);
		TopRoute route2 = mock(TopRoute.class);
		TopRoute route3 = mock(TopRoute.class);
		when(route1.getFrom()).thenReturn("BUE");
		when(route2.getFrom()).thenReturn("MIA");
		when(route3.getFrom()).thenReturn("BUE");
		when(route1.getTo()).thenReturn("SAO");
		when(route2.getTo()).thenReturn("SSA");
		when(route3.getTo()).thenReturn("MIA");
		when(topRoutesReader.getTopRoutes()).thenReturn(Arrays.asList(route1, route2, route3));
		Destination destination1 = mock(Destination.class);
		Destination destination2 = mock(Destination.class);
		Destination destination3 = mock(Destination.class);
		when(destination1.getAmount()).thenReturn(BigDecimal.valueOf(500));
		when(destination2.getAmount()).thenReturn(BigDecimal.valueOf(200));
		when(destination3.getAmount()).thenReturn(BigDecimal.valueOf(200));
		when(cheapestDestinationObtainer.getCheapestDestination("BUE", "SAO")).thenReturn(destination1);
		when(cheapestDestinationObtainer.getCheapestDestination("MIA", "SSA")).thenReturn(destination2);
		when(cheapestDestinationObtainer.getCheapestDestination("BUE", "MIA")).thenReturn(destination3);
		bestTrips.setBestTrips("BUE", BigDecimal.valueOf(600));
		assertTrue((bestTrips.getDestinationsTaken().get(0) == destination3) && (bestTrips.getDestinationsTaken().get(1) == destination2));
	}
	
	@Test
	public void testGetPossibleDestinations() {
		TopRoute route1 = mock(TopRoute.class);
		TopRoute route2 = mock(TopRoute.class);
		TopRoute route3 = mock(TopRoute.class);
//		Flight flight1 = mock(Flight.class);
//		Flight flight2 = mock(Flight.class);
//		Flight flight3 = mock(Flight.class);
//		when(flight1.getCityFrom()).thenReturn("BUE");
//		when(flight2.getCityFrom()).thenReturn("MIA");
//		when(flight3.getCityFrom()).thenReturn("BUE");
//		when(flight1.getCityTo()).thenReturn("SAO");
//		when(flight2.getCityTo()).thenReturn("MIA");
//		when(flight3.getCityTo()).thenReturn("BUE");
		when(topRoutesReader.getTopRoutes()).thenReturn(Arrays.asList(route1, route2, route3));
		when(route1.getFrom()).thenReturn("BUE");
		when(route2.getFrom()).thenReturn("MIA");
		when(route3.getFrom()).thenReturn("BUE");
//		when(route1.getTo()).thenReturn("SAO");
//		when(route2.getTo()).thenReturn("MIA");
//		when(route3.getTo()).thenReturn("BUE");
//		when(cheapestFlightObtainer.getCheapestFlight(route1.getFrom(), route1.getTo())).thenReturn(flight1);
//		when(cheapestFlightObtainer.getCheapestFlight(route2.getFrom(), route2.getTo())).thenReturn(flight2);
//		when(cheapestFlightObtainer.getCheapestFlight(route3.getFrom(), route3.getTo())).thenReturn(flight3);
		assertTrue( (bestTrips.getPossibleDestinations("BUE").get(0) == route1) && (bestTrips.getPossibleDestinations("BUE").get(1) == route3));
	}
	
	@Test
	public void testGetCheapestDestination() {
		TopRoute route1 = mock(TopRoute.class);
		TopRoute route2 = mock(TopRoute.class);
		TopRoute route3 = mock(TopRoute.class);
		when(route1.getFrom()).thenReturn("BUE");
		when(route2.getFrom()).thenReturn("MIA");
		when(route3.getFrom()).thenReturn("BUE");
		when(route1.getTo()).thenReturn("MIA");
		when(route2.getTo()).thenReturn("SSA");
		when(route3.getTo()).thenReturn("SAO");
		when(topRoutesReader.getTopRoutes()).thenReturn(Arrays.asList(route1, route2, route3));
		Destination destination1 = mock(Destination.class);
		Destination destination2 = mock(Destination.class);
		Destination destination3 = mock(Destination.class);
		when(destination1.getAmount()).thenReturn(BigDecimal.valueOf(500));
		when(destination2.getAmount()).thenReturn(BigDecimal.valueOf(150));
		when(destination3.getAmount()).thenReturn(BigDecimal.valueOf(200));
//		Flight flight1 = mock(Flight.class);
//		Flight flight2 = mock(Flight.class);
//		Flight flight3 = mock(Flight.class);
//		when(flight1.getCityFrom()).thenReturn("BUE");
//		when(flight2.getCityFrom()).thenReturn("MIA");
//		when(flight3.getCityFrom()).thenReturn("BUE");
//		when(flight1.getCityTo()).thenReturn("SAO");
//		when(flight2.getCityTo()).thenReturn("MIA");
//		when(flight3.getCityTo()).thenReturn("BUE");
		when(cheapestDestinationObtainer.getCheapestDestination("BUE", "MIA")).thenReturn(destination1);
		when(cheapestDestinationObtainer.getCheapestDestination("MIA", "SSA")).thenReturn(destination2);
		when(cheapestDestinationObtainer.getCheapestDestination("BUE", "SAO")).thenReturn(destination3);
//		when(route1.getFrom()).thenReturn("BUE");
//		when(route2.getFrom()).thenReturn("MIA");
//		when(route3.getFrom()).thenReturn("BUE");
//		when(route1.getTo()).thenReturn("SAO");
//		when(route2.getTo()).thenReturn("MIA");
//		when(route3.getTo()).thenReturn("BUE");
//		when(cheapestFlightObtainer.getCheapestFlight(route1.getFrom(), route1.getTo())).thenReturn(flight1);
//		when(cheapestFlightObtainer.getCheapestFlight(route2.getFrom(), route2.getTo())).thenReturn(flight2);
//		when(cheapestFlightObtainer.getCheapestFlight(route3.getFrom(), route3.get9To())).thenReturn(flight3);
		assertTrue( (bestTrips.getCheapestDestination("BUE") == destination3));
	}
	
	@Test
	public void testNotVisitedDestination() {
		Destination destination1 = mock(Destination.class);
		Destination destination2 = mock(Destination.class);
		Destination destination3 = mock(Destination.class);
		when(destination1.getCityCode()).thenReturn("BUE");
		when(destination2.getCityCode()).thenReturn("MIA");
		when(destination3.getCityCode()).thenReturn("SSA");
		List<Destination> aListOfDestinations = new ArrayList<Destination>();
		aListOfDestinations.add(destination1);
		aListOfDestinations.add(destination2);
		aListOfDestinations.add(destination3);
		bestTrips.setDestinationsTaken(aListOfDestinations);
		//assertTrue(bestTrips.notVisitedDestination("SAO"));
		assertTrue(bestTrips.notVisitedDestination("SAO"));
		
	}


}
