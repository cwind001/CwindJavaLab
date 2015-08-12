package com.cwind.designpatterns.strategy;

public class StrategyContext {
	IStrategy strategy;
	
	public StrategyContext(IStrategy strategy){
		this.strategy = strategy;
	}
	
	public void execute(){
		strategy.doSomething();
	}
}
