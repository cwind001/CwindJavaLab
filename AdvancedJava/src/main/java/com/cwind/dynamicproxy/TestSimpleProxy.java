package com.cwind.dynamicproxy;

public class TestSimpleProxy {
	public static void main(String[] args) {
		IService service = new ServiceImpl();
		service.sayHello();
		
		service = (IService) new CwindProxy().bind(new ServiceImpl()); 
		service.sayHello();
		service.goToSchool();
	}
}
