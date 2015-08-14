package com.cwind.designpatterns.mediator;

public class ConcreteMediator extends AbstractMediator{
	
	public ConcreteMediator(AbstractColleague colleagueA,
			AbstractColleague colleagueB) {
		super(colleagueA, colleagueB);
	}

	public void AaffectB(){
		colleagueB.setNumber(colleagueA.getNumber()*10);
	}
	
	public void BaffectA(){
		colleagueA.setNumber(colleagueB.getNumber()/10);
	}
}
