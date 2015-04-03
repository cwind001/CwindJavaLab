package com.cwind.test;

import java.util.ArrayList;
import java.util.List;

public class BoolListTest {
	public static void main(String[] args){
		String[] testStrs = {"1","4"};
		List<Boolean> boolList = new ArrayList<Boolean>(5);
		for(int i=0; i<5; i++){
			boolList.add(false);
		}
		System.out.println(boolList.size());
		int location;
		for(int i=0; i<testStrs.length; i++){
			location = Integer.parseInt(testStrs[i]);
			boolList.set(location, true);
		}
		
		for(int index=0; index < boolList.size(); index++)
			System.out.println(boolList.get(index));
	}
}
