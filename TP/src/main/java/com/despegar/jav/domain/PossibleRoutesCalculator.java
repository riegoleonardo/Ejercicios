package com.despegar.jav.domain;

import java.util.ArrayList;
import java.util.List;

import com.despegar.jav.example.TopRoute;
import com.despegar.jav.example.TopRoutesReader;

public class PossibleRoutesCalculator {
	
	private TopRoutesReader topRoutesReader;
	
	public PossibleRoutesCalculator(TopRoutesReader topRoutesReader) {
		this.topRoutesReader = topRoutesReader;
	}
	
	public PossibleRoutesCalculator() {

	}

	public TopRoutesReader getTopRoutesReader() {
		return topRoutesReader;
	}

	public void setTopRoutesReader(TopRoutesReader topRoutesReader) {
		this.topRoutesReader = topRoutesReader;
	}

	public List<TopRoute> getPossibleDestinations(String actualCity) {
		List<TopRoute> topRoutesCollection = topRoutesReader.getTopRoutes();
		ArrayList<TopRoute> possibleDestinations = new ArrayList<TopRoute>();
		for (TopRoute aRoute : topRoutesCollection) {
			if (aRoute.getFrom().equals(actualCity)) {
				possibleDestinations.add(aRoute);
			}
		}
		return possibleDestinations;
	}

}
