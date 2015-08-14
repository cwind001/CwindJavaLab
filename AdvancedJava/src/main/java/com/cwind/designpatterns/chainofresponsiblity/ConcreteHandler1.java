package com.cwind.designpatterns.chainofresponsiblity;

public class ConcreteHandler1 extends Handler {

	@Override
	public Level getHandlerLevel() {
		return new Level(1);
	}

	@Override
	public Response response(Request req) {
		System.out.println("This request is handled by handler1");
		return null;
	}

}
