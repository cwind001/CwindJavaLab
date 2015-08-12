package com.cwind.designpatterns.visitor;

public class Visitor implements IVisitor{

	@Override
	public void visit(ConcreteElement1 ele1) {
		ele1.doSomething();
	}

	@Override
	public void visit(ConcreteElement2 ele2) {
		ele2.doSomething();
	}

}
