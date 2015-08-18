package com.cwind.dynamicproxy;

public class LogAdvice {

	public void beforeLog() {
		System.out.println("Start executing.");
	}
	
	public void afterLog() {
		System.out.println("Finish executing.");
	}
	
}
