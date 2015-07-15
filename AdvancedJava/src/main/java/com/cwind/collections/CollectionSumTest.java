package com.cwind.collections;

import java.util.ArrayList;
import java.util.List;

public class CollectionSumTest {
	public static void main(String[] args){
		List list = new ArrayList<String>();
		list.add("hello");
		list.add("world");
		int size = list.size();
		System.out.println(size);
		list.add("hi");
		System.out.println(size);
		System.out.println(list.size());
	}
}
