package com.cwind.designpatterns.observer;

public class AbstractObserver {
	public void update(){
		System.out.println(this.getClass().getName()+" observes event, will be updated.");
	}
}
