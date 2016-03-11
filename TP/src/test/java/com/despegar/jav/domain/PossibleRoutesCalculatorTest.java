package com.despegar.jav.domain;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.despegar.jav.example.TopRoute;
import com.despegar.jav.example.TopRoutesReader;

public class PossibleRoutesCalculatorTest {
	
	private TopRoutesReader topRoutesReader;
	private PossibleRoutesCalculator possibleRoutesCalculator;
	
	@Before
	public void setUp() {
		topRoutesReader = mock(TopRoutesReader.class);
		possibleRoutesCalculator = new PossibleRoutesCalculator();
		possibleRoutesCalculator.setTopRoutesReader(topRoutesReader);
	}

	@Test
	public void testGetPossibleDestinations() {
		TopRoute route1 = mock(TopRoute.class);
		TopRoute route2 = mock(TopRoute.class);
		TopRoute route3 = mock(TopRoute.class);
		when(topRoutesReader.getTopRoutes()).thenReturn(Arrays.asList(route1, route2, route3));
		when(route1.getFrom()).thenReturn("BUE");
		when(route2.getFrom()).thenReturn("MIA");
		when(route3.getFrom()).thenReturn("BUE");
		assertTrue( (possibleRoutesCalculator.getPossibleDestinations("BUE").get(0) == route1) && (possibleRoutesCalculator.getPossibleDestinations("BUE").get(1) == route3));
	}
	
}
