package com.cwind.jackson;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonTypeInfo;

import com.mstr.util.map.Mappable;

//@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")
public class Course implements Mappable{
	private String courseName;
	
	private Teacher teacher;
	
	public Course(){
		this.courseName = "default course";
	}
	public Course(String courseName){
		this.courseName = courseName;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseInfo(){
		return "course info";
	}
	@Override
	public Map read() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void update(Map arg0) {
		// TODO Auto-generated method stub
		
	}
}
