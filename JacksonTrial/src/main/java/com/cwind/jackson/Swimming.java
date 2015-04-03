package com.cwind.jackson;

public class Swimming extends Sport {
	private String distance;
	
	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public Swimming(){
		this.setSportName("swimming");
		this.setDistance("500m");
	}

	@Override
	public void printSport() {
		System.out.println("===swimming==");
		System.out.println("Favourite Sport: "+this.getSportName());
		System.out.println("Distance: "+this.getDistance());
	}
}
