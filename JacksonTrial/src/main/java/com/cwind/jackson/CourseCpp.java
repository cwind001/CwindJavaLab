package com.cwind.jackson;

public class CourseCpp extends Course {
	public CourseCpp(){
		this.setCourseName("C++ Course");
	}
	public String getCourseInfo(){
		return "c++ - "+ this.getCourseName();
	}
	public int languageRank(){
		return 5;
	}
	public String cppComment(){
		return "Difficult";
	}
}
