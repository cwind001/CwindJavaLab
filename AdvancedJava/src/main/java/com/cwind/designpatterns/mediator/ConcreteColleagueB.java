package com.cwind.designpatterns.mediator;

public class ConcreteColleagueB extends AbstractColleague {

	@Override
	public void setNumber(int number, AbstractMediator mediator) {
		this.setNumber(number);
		mediator.BaffectA();
	}
}
