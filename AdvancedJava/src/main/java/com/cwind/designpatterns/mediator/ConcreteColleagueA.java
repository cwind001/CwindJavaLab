package com.cwind.designpatterns.mediator;

public class ConcreteColleagueA extends AbstractColleague {

	@Override
	public void setNumber(int number, AbstractMediator mediator) {
		this.setNumber(number);
		mediator.AaffectB();
	}
}
