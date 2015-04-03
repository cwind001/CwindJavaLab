package com.cwind.htcc;

import java.util.ArrayList;
import java.util.List;

public class HTCCUser {
	
	private String firstName;
	private String lastName;


	private String userName;
	private String id ;
	private List<String> roles =new ArrayList<String>(0);
	
	public HTCCUser(){
		firstName = "Billy";
		lastName = "Chen";
		userName = "wchen@angel.com";
		id = "tempId";
		roles.add("ROLE_AGENT");
		roles.add("ROLES_SUPERVISOR");
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
    
}
