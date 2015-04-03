package com.cwind.callback;

import java.sql.Timestamp;

public class ExecutionTimeTest {
	public static void testMethod1(){
		for(int i=0; i<100000000; i++){
			
		}
	}
	
	public static void testMethod2(){
		for(int i=0; i<1000000000; i++){
			
		}
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void printExecutionTime(){
		long startTime = System.currentTimeMillis();
		testMethod1();
		long endTime = System.currentTimeMillis();
		System.out.println("Function execution time: "+(endTime - startTime));
	}
	
	public static void main(String[] args){
		ExecutionTimeTest ett = new ExecutionTimeTest();
		ett.printExecutionTime();
		System.out.println("================");
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		System.out.println(ts.toGMTString());
	}

}
