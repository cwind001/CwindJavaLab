package com.cwind.designpatterns.visitor;

import java.util.ArrayList;
import java.util.List;

public class TestVisitor {
	
	public static void main(String[] args){
		List<Element> elements = new ArrayList<Element>();
		for(int i=0;i<10;i++){
			if(Math.random()<0.5){
				elements.add(new ConcreteElement1());
			}else{
				elements.add(new ConcreteElement2());
			}
		}
		IVisitor visitor = new Visitor();
		for(Element ele : elements){
			ele.accept(visitor);
		}
	}

}
