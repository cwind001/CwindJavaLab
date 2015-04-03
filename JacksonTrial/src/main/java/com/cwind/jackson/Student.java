package com.cwind.jackson;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import com.mstr.util.map.MappableList;

@XmlRootElement
public class Student {
	private int id;
	private String name;
	private String email;
	private String address;
	private Birthday birthday;
	private Sport sport;
	private List<Course> courselist = new MappableList<Course>(Course.class);
	private int age;
	
	@JsonIgnore
	public int getAge() {
		return age+100;
	}
	
	@JsonProperty("age")
	public int afdfAge2(){
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setAge(String age){
		this.age = Integer.parseInt(age);
	}
	
	public Sport getSport() {
		return sport;
	}

	public List<Course> getCourselist() {
		return courselist;
	}

	public void setCourselist(List<Course> courselist) {
		this.courselist = courselist;
	}
	
	public void addCourse(Course course){
		this.courselist.add(course);
	}

	@XmlElement
	public void setSport(Sport sport) {
		this.sport = sport;
	}

	//setter、getter
    public String toString() {
        return this.name + "#" + this.id + "#" + this.address + "#" + this.birthday + "#" + this.email;
    }

	public int getId() {
		return id;
	}

	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}
	
	@XmlElement
	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}
	
	@XmlElement
	public void setAddress(String address) {
		this.address = address;
	}

	public Birthday getBirthday() {
		return birthday;
	}

	@XmlElement
	public void setBirthday(Birthday birthday) {
		this.birthday = birthday;
	}
}
