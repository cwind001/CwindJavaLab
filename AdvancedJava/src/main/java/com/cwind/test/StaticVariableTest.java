package com.cwind.test;

public class StaticVariableTest {

	static int index;
	static Account account;
	public static void main(String[] args) {
		StaticVariableTest test = new StaticVariableTest();
		System.out.println(index);
		System.out.println(test.account);
	}
}

class Account{
	String name;
	
	Account(){
		name = "Default";
	}
	
	String getName(){
		return this.name;
	}
}