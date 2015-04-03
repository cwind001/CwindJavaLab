package com.cwind.jsonlib;

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
