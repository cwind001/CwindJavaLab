package com.cwind.jackson;

public class CourseJava extends Course {
	public CourseJava(){
		this.setCourseName("Java Course");
	}
	public String getCourseInfo(){
		return "java - "+ this.getCourseName();
	}
	private int difficultRank;
	public int getDifficultRank() {
		return difficultRank;
	}
	public void setDifficultRank(int difficultRank) {
		this.difficultRank = difficultRank;
	}
	public String comment;
}
