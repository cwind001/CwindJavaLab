package com.cwind.designpatterns.memento;

import java.util.Map;
import com.cwind.util.BeanUtils;



class MultiStateMemento {
	Map<String, Object> cache;
	
	public MultiStateMemento(Map<String, Object> map){
		this.cache = map;
	}

	public Map<String, Object> getCache() {
		return cache;
	}

	public void setCache(Map<String, Object> cache) {
		this.cache = cache;
	}
	
}

class MultiStateCareTaker {
	MultiStateMemento memento;

	public MultiStateMemento getMemento() {
		return memento;
	}

	public void setMemento(MultiStateMemento memento) {
		this.memento = memento;
	}
}

public class TestMultiStateOriginator {
	public static void main(String[] args){
		MultiStateOriginator originator = new MultiStateOriginator();
		originator.setName("Bill");
		originator.setGender("Male");
		originator.setAge(29);
		System.out.println("State of originator: " + originator);
		
		MultiStateCareTaker careTaker = new MultiStateCareTaker();
		careTaker.setMemento(originator.createMemento());
		originator.setName("Lily");
		originator.setGender("Female");
		originator.setAge(29);
		System.out.println("State of originator: " + originator);
		
		originator.restoreMemento(careTaker.getMemento());
		System.out.println("State of originator: " + originator);
	}
}
