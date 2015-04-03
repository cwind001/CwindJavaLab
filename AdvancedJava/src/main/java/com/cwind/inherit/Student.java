package com.cwind.inherit;

public class Student extends Person{
	private School university;

	public School getUniversity() {
		return university;
	}

	public void setUniversity(School university) {
		this.university = university;
	}
}
