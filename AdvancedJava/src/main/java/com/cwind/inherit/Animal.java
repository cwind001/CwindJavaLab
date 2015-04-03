package com.cwind.inherit;

public class Animal {
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}

	public Animal(){
		this.name = "Animal";
		this.age = 10;
	}
	
	public Animal(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public void bark(){
		System.out.println("I'm "+this.getName());
		printAge();
	}
	
	private void printAge(){
		System.out.println("I'm "+this.getAge());
	}
}
