package com.cwind.jackson;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.annotate.JsonTypeInfo;

//@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")
public abstract class Sport {
	private String sportName;

	public Sport(){
		sportName = "sport";
	}
	
	public String getSportName() {
		return sportName;
	}

	public void setSportName(String sportName) {
		this.sportName = sportName;
	}
	
	public abstract void printSport();
	
}
