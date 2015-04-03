package com.cwind.inherit;

public class Dog extends Animal {
	public Dog(){
		super();
		this.setName("Dog");
	}
	
	public void bark(){
		System.out.println("Hey");
		super.bark();
		
	}
}
