package com.cwind.introspector;

public class Titan extends Superhero {
	private double height;
	private double weight;
	
	public Titan(double height, double weight) {
		super();
		this.height = height;
		this.weight = weight;
	}
	
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
}
