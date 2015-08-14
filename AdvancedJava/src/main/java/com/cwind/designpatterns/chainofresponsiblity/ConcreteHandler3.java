package com.cwind.designpatterns.chainofresponsiblity;

public class ConcreteHandler3 extends Handler {

	@Override
	public Level getHandlerLevel() {
		return new Level(5);
	}

	@Override
	public Response response(Request req) {
		System.out.println("This request is handled by handler 3");
		return null;
	}

}
