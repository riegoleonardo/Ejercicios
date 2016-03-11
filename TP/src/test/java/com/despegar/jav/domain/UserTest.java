package com.despegar.jav.domain;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
	
	private User user;
	
	@Before
	public void setUp() {
		user = new User();
		user.setWallet(BigDecimal.valueOf(500));
		Travel destination1 = mock(Travel.class);
		Travel destination2 = mock(Travel.class);
		Travel destination3 = mock(Travel.class);
		when(destination1.getCityCode()).thenReturn("BUE");
		when(destination2.getCityCode()).thenReturn("MIA");
		when(destination3.getCityCode()).thenReturn("SSA");
		List<Travel> aListOfDestinations = new ArrayList<Travel>();
		aListOfDestinations.add(destination1);
		aListOfDestinations.add(destination2);
		aListOfDestinations.add(destination3);
		user.setVisitedDestinations(aListOfDestinations);
	}
	
	@Test
	public void testNotVisitedDestination() {
		assertTrue(user.notVisitedDestination("SAO"));
		
	}
	
	@Test
	public void testVisitedDestination() {
			assertFalse(user.notVisitedDestination("SSA"));
	}
	
	@Test
	public void testAddDestination() {
		Travel destination4 = mock(Travel.class);
		when(destination4.getAmount()).thenReturn(BigDecimal.valueOf(300));
		user.addDestination(destination4);
		assertEquals(user.getVisitedDestinations().get(3), destination4);
		assertEquals(user.getWallet(), BigDecimal.valueOf(200));
	}
}
