package com.cwind.collections;

public class InternMethodTest {
	public static void main(String[] args){
		String str1 = "str";
		String str2 = str1.intern();
		System.out.println(str1==str2);
		System.out.println(str1.equals(str2));
		
		String str3 = new String("str");
		String str4 = str3.intern();
		System.out.println(str3==str4);
		System.out.println(str3.equals(str4));
	}
}
