package com.cwind.string;

public class SubStringTest {
	public static void main(String[] args){
		String input1 = " [{1},{2}] ";
		String input2 = " [{3},{4}] ";
		String result = input1.trim().substring(0, input1.trim().lastIndexOf("]"));
		result = result + ", "+ input2.trim().substring(input2.trim().indexOf("[")+1);
		
		System.out.println(result);
	}
}
