package com.cwind.designpatterns.chainofresponsiblity;

public class Level {
	private int level;
	public Level(int level) {
		this.level = level;
	}
	
	public boolean above(Level level){
		return this.level>level.getLevel();
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	
}
