package com.cwind.designpatterns.visitor;

class Father{
	public void accept(Executor executor){
		executor.exec(this);
	}
}

class Son1 extends Father {
	public void accept(Executor executor){
		executor.exec(this);
	}
}

class Son2 extends Father {
	public void accept(Executor executor){
		executor.exec(this);
	}
}

class Executor {
	public void exec(Father father){
		System.out.println("Father exec.");
	}
	
	public void exec(Son1 son1) {
		System.out.println("Son1 exec.");
	}
	
	public void exec(Son2 son2) {
		System.out.println("Son2 exec.");
	}
}

public class TestDoubleDispatch {
	public static void main(String[] args){
		Father father = new Father();
		Father son1 = new Son1();
		Father son2 = new Son2();
		
		Executor executor = new Executor();
		father.accept(executor);
		son1.accept(executor);
		son2.accept(executor);
	}
}
