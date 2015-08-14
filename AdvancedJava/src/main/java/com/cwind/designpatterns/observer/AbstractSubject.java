package com.cwind.designpatterns.observer;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class AbstractSubject {
	List<AbstractObserver> observers = new CopyOnWriteArrayList<AbstractObserver>();
	
	public void addObserver(AbstractObserver observer) {
		observers.add(observer);
	}
	
	public void deleteObserver(AbstractObserver observer) {
		observers.remove(observer);
	}
	
	public void notifyObserver(){
		for(AbstractObserver observer : observers) {
			observer.update();
		}
	}

	public abstract void doSomething();
}
