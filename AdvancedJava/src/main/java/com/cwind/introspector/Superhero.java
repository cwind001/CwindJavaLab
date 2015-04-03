package com.cwind.introspector;

public class Superhero {
	private String name;
	private String superPower;
	private int age;
	
	public Superhero(){
		this.name = "defaultName";
		this.name = "defaultSuperPower";
		this.age = 0;
	}
	
	public Superhero(String name, String superPower, int age) {
		super();
		this.name = name;
		this.superPower = superPower;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSuperPower() {
		return superPower;
	}
	public void setSuperPower(String superPower) {
		this.superPower = superPower;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
