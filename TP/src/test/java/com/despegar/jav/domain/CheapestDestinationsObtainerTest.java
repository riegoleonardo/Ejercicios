package com.despegar.jav.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.despegar.jav.example.TopRoute;

public class CheapestDestinationsObtainerTest {
	
	private CheapestDestinationsObtainer cheapestDestinationsObtainer;
	private PossibleRoutesCalculator possibleRoutesCalculator;
	private CheapestTravelConnector cheapestDestinationConnector;
	private User user;

	@Before
	public void setUp() {
		possibleRoutesCalculator = mock(PossibleRoutesCalculator.class);
		cheapestDestinationConnector = mock(CheapestTravelConnector.class);
		cheapestDestinationsObtainer = new CheapestDestinationsObtainer(cheapestDestinationConnector, possibleRoutesCalculator);
		user = mock(User.class);
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
		List<TopRoute> topRoutesList = new ArrayList<TopRoute>();
		topRoutesList.add(route1);
		topRoutesList.add(route2);
		topRoutesList.add(route3);
		when(possibleRoutesCalculator.getPossibleDestinations("BUE")).thenReturn(topRoutesList);
		Travel destination1 = mock(Travel.class);
		Travel destination2 = mock(Travel.class);
		Travel destination3 = mock(Travel.class);
		when(destination1.getAmount()).thenReturn(BigDecimal.valueOf(150));
		when(destination2.getAmount()).thenReturn(BigDecimal.valueOf(200));
		when(destination3.getAmount()).thenReturn(BigDecimal.valueOf(500));
		when(cheapestDestinationConnector.getCheapestTravel(route1.getFrom(), route1.getTo())).thenReturn(destination1);
		when(cheapestDestinationConnector.getCheapestTravel(route2.getFrom(), route2.getTo())).thenReturn(destination2);
		when(cheapestDestinationConnector.getCheapestTravel(route3.getFrom(), route3.getTo())).thenReturn(destination3);
		when(user.notVisitedDestination(anyString())).thenReturn(true);
		cheapestDestinationsObtainer.setPossibleRoutesCalculator(possibleRoutesCalculator);
		cheapestDestinationsObtainer.setCheapestDestinationConnector(cheapestDestinationConnector);
		assertTrue( cheapestDestinationsObtainer.getCheapestDestination(user, "BUE") == destination1);
	}
	
	@Test
	public void testGetCheapestsDestinations() {
		TopRoute route1 = mock(TopRoute.class);
		TopRoute route2 = mock(TopRoute.class);
		TopRoute route3 = mock(TopRoute.class);
		when(route1.getFrom()).thenReturn("BUE");
		when(route2.getFrom()).thenReturn("MIA");
		when(route3.getFrom()).thenReturn("BUE");
		when(route1.getTo()).thenReturn("MIA");
		when(route2.getTo()).thenReturn("SSA");
		when(route3.getTo()).thenReturn("SAO");
		List<TopRoute> topRoutesList = new ArrayList<TopRoute>();
		topRoutesList.add(route1);
		topRoutesList.add(route2);
		topRoutesList.add(route3);
		when(possibleRoutesCalculator.getPossibleDestinations("BUE")).thenReturn(topRoutesList);
		Travel destination1 = mock(Travel.class);
		Travel destination2 = mock(Travel.class);
		Travel destination3 = mock(Travel.class);
		when(destination1.getAmount()).thenReturn(BigDecimal.valueOf(150));
		when(destination2.getAmount()).thenReturn(BigDecimal.valueOf(200));
		when(destination3.getAmount()).thenReturn(BigDecimal.valueOf(500));
		when(cheapestDestinationConnector.getCheapestTravel(route1.getFrom(), route1.getTo())).thenReturn(destination1);
		when(cheapestDestinationConnector.getCheapestTravel(route2.getFrom(), route2.getTo())).thenReturn(destination2);
		when(cheapestDestinationConnector.getCheapestTravel(route3.getFrom(), route3.getTo())).thenReturn(destination3);
		when(user.notVisitedDestination(anyString())).thenReturn(true);
		cheapestDestinationsObtainer.setPossibleRoutesCalculator(possibleRoutesCalculator);
		cheapestDestinationsObtainer.setCheapestDestinationConnector(cheapestDestinationConnector);
		User aUser = new User(BigDecimal.valueOf(1500),"BUE");
		cheapestDestinationsObtainer.calculateCheapestDestinations(aUser);
		assertEquals(aUser.getVisitedDestinations().get(0), destination1);
		assertEquals(aUser.getVisitedDestinations().get(1), destination2);
	}
	
	
	
	
}
