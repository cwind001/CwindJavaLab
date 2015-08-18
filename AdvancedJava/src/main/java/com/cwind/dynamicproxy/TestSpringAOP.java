package com.cwind.dynamicproxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringAOP {

	public static void main(String[] args){
		ApplicationContext ac = new ClassPathXmlApplicationContext("springaop.xml");
		IService service = (IService) ac.getBean("serviceImpl");
		service.goToSchool();
	}
}
