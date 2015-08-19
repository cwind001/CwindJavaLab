package com.cwind.multithreading;

public class JoinTest implements Runnable{

	static int count = 0;
	
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			count++;
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Runnable joinTest = new JoinTest();
		Thread t = new Thread(joinTest);
		t.start();
		t.join();
		System.out.println("Count: " + count);
	}

}
