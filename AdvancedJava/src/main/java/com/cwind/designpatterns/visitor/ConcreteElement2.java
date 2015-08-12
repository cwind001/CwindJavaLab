package com.cwind.designpatterns.visitor;

public class ConcreteElement2 extends Element {

	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public void doSomething() {
		System.out.println("Concrete Element 2 is doing something.");
	}

}
