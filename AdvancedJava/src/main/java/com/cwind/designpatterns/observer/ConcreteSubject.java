package com.cwind.designpatterns.observer;

public class ConcreteSubject extends AbstractSubject {

	@Override
	public void doSomething() {
		System.out.println("The subject is doing something, event is fired.");
		this.notifyObserver();
	}

}
