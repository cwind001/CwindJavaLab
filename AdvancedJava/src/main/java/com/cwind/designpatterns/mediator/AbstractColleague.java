package com.cwind.designpatterns.mediator;

public abstract class AbstractColleague {
	private int number;
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public abstract void setNumber(int number, AbstractMediator mediator);
}
