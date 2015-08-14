package com.cwind.designpatterns.mediator;

public abstract class AbstractMediator {
	AbstractColleague colleagueA;
	AbstractColleague colleagueB;
	
	public AbstractMediator(AbstractColleague colleagueA, AbstractColleague colleagueB){
		this.colleagueA = colleagueA;
		this.colleagueB = colleagueB;
	}
	
	public abstract void AaffectB();
	public abstract void BaffectA();
}
