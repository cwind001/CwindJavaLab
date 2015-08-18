package com.cwind.dynamicproxy;

public class TestCglibProxy {
	public static void main(String[] args) {
		IService service = (ServiceImpl) new CglibProxyFactory().bind(new ServiceImpl());
		service.goToSchool();
	}
}
