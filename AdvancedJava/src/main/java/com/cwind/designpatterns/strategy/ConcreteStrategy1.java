package com.cwind.designpatterns.strategy;

public class ConcreteStrategy1 implements IStrategy {

	@Override
	public void doSomething() {
		System.out.println("Concrete Strategy1");
	}
}
