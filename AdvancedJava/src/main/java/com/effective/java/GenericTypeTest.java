package com.effective.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class GenericTypeTest {

	public static void main(String[] args){
		Set<?> set = new HashSet();
		set.add(null);
		printSetInfo(set);
		Set<GenericTypeTest> set2 = new HashSet();
		set2.add(new GenericTypeTest());
		printSetInfo(set2);
		Set<String> set3 = new HashSet<String>();
		printSetInfo(set3);
		
		//Item #25
		Object[] objectArray = new Long[1];
		objectArray[0] = "I don't fit in";
//		List<Object> ol = new ArrayList<Long>();
//		ol.add("I don't fit in");
	}
	
	private static void printSetInfo(Set<?> set){
		System.out.println("Set size: " + set.size());
		System.out.println("Set info: " + set.getClass());
	}
	
}
