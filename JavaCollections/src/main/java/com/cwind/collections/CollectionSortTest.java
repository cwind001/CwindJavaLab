package com.cwind.collections;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionSortTest {
	public static void main(String[] args){
		System.out.println("****Collection Sort Test****");
		ArrayList<String> al = new ArrayList<String>();
		al.add("Elaine");
		al.add("Alan");
		al.add("Billy");
		
		for(String str : al){
			System.out.println(str);
		}
		
		Collections.sort(al);
		for(String str : al){
			System.out.println(str);
		}
	}
}
