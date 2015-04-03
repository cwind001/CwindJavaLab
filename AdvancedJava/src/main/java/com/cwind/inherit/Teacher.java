package com.cwind.inherit;

public class Teacher extends Person{
	private School university;

	public School getUniversity() {
		return university;
	}

	public void setUniversity(School university) {
		this.university = university;
	}
}
