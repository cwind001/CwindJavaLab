package com.cwind.designpatterns.memento;

public class TestMemento {
	public static void main(String[] args) {
		Originator originator = new Originator();
		originator.setState("Original State");
		System.out.println("State of originator: "+originator.getState());
		CareTaker careTaker = new CareTaker();
		careTaker.setMemento(originator.createMemento());
		originator.setState("Updated State");
		System.out.println("State of originator: "+originator.getState());
		originator.restoreMemento(careTaker.getMemento());
		System.out.println("State of originator: "+originator.getState());
	}
}
