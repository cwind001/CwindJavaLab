package com.cwind.test;

public class NullStrTest {
	public static void main(String[] args){
		String nullStr1 = null;
		String nullStr2 = "null";
		System.out.println("null".equals(nullStr1));
		System.out.println("null".equals(nullStr2));
		System.out.println(nullStr1==null);
		
		String result = "abc"+nullStr1;
		System.out.println(result.length());
	}
}
