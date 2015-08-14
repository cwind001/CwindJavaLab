package com.cwind.designpatterns.chainofresponsiblity;

public class Request {
	private Level level;
	public Request(Level level){
		this.level = level;
	}
	
	public Level getLevel() {
		return level;
	}
	
	public void setLevel(Level level) {
		this.level = level;
	}
	
}
