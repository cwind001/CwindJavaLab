package com.cwind.inherit;

import java.util.ArrayList;
import java.util.List;

import com.cwind.enumer.Meta;

public class Person {
	private String name;
	private int age;
	private String message = Meta.PERSON_MESSAGE();

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		lazyDogs = new ArrayList();
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	private List<String> lazyDogs;

	public List<String> getLazyDogs() {
		return lazyDogs;
	}

	public void setLazyDogs(List<String> lazyDogs) {
		this.lazyDogs = lazyDogs;
	}
	
	
}
