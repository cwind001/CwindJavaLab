package com.cwind.designpatterns.chainofresponsiblity;

public class TestChainOfResponsiblity {
	public static void main(String[] args){
		Request req1 = new Request(new Level(1));
		Request req2 = new Request(new Level(2));
		Request req3 = new Request(new Level(6));
		Handler handler1 = new ConcreteHandler1();
		Handler handler2 = new ConcreteHandler2();
		Handler handler3 = new ConcreteHandler3();
		handler1.setNexeHandler(handler2);
		handler2.setNexeHandler(handler3);
		
		handler1.handleRequest(req1);
		handler1.handleRequest(req2);
		handler1.handleRequest(req3);
	}
}
