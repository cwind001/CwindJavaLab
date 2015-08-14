package com.cwind.designpatterns.mediator;

public class TestMediator {
	public static void main(String[] args) {
		AbstractColleague colleagueA = new ConcreteColleagueA();
		AbstractColleague colleagueB = new ConcreteColleagueB();
		AbstractMediator mediator = new ConcreteMediator(colleagueA, colleagueB); 
		System.out.println("Colleagues work without mediator.");
		colleagueA.setNumber(15);
		System.out.println("Number of A: "+colleagueA.getNumber()+", number of B: "+colleagueB.getNumber());
		colleagueB.setNumber(25);
		System.out.println("Number of A: "+colleagueA.getNumber()+", number of B: "+colleagueB.getNumber());
	
		System.out.println("Colleagues work with mediator.");
		colleagueA.setNumber(15, mediator);
		System.out.println("Number of A: "+colleagueA.getNumber()+", number of B: "+colleagueB.getNumber());
		colleagueB.setNumber(25, mediator);
		System.out.println("Number of A: "+colleagueA.getNumber()+", number of B: "+colleagueB.getNumber());
	}
}
