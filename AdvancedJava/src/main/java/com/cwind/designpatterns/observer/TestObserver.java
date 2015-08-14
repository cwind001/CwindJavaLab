package com.cwind.designpatterns.observer;

public class TestObserver {
	public static void main(String[] args){
		AbstractObserver ob1 = new ConcreteObserver1();
		AbstractObserver ob2 = new ConcreteObserver2();
		AbstractSubject sub = new ConcreteSubject();
		sub.addObserver(ob1);
		sub.addObserver(ob2);
		sub.doSomething();
	}
}
