package com.cwind.designpatterns.strategy;

public class TestStrategy {
	public static void main(String[] args) {
		StrategyContext context = new StrategyContext(new ConcreteStrategy1());
		context.execute();
		context = new StrategyContext(new ConcreteStrategy2());
		context.execute();
	}
}
