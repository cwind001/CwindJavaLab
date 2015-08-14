package com.cwind.designpatterns.chainofresponsiblity;

public class ConcreteHandler2 extends Handler {

	@Override
	public Level getHandlerLevel() {
		return new Level(3);
	}

	@Override
	public Response response(Request req) {
		System.out.println("This request is handled by handler 2");
		return null;
	}

}
