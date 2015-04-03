package com.cwind.test;

public class StringToBooleanTest {
	public static void main(String[] args) {
		boolean bool1 = Boolean.valueOf("true").booleanValue();
		boolean bool2 = Boolean.valueOf("Hello world!").booleanValue();
		System.out.println("bool1 - " + bool1);
		System.out.println("bool2 - " + bool2);

	}
}
