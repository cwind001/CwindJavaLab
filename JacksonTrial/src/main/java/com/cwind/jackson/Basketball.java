package com.cwind.jackson;

public class Basketball extends Sport {
	private String size;
	
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Basketball(){
		this.setSportName("basketball");
		this.setSize("big");
	}

	@Override
	public void printSport() {
		System.out.println("===basketball==");
		System.out.println("Favourite Sport: "+this.getSportName());
		System.out.println("Size: "+this.getSize());
	}
	
}
