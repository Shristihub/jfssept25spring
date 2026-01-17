package com.restaurantapp.model;

public enum Cuisine {
	NI("NORTH INDIAN"), 
	SI("SOUTH INDIAN"), 
	CHINESE("CHINESE"), 
	ITALIAN("ITALIAN"), 
	MEXICAN("MEXICAN");

	private String cuisineType;

	private Cuisine(String cuisine) {
		this.cuisineType = cuisine;
	}

	public String getCuisineType() {
		return cuisineType;
	}

}
