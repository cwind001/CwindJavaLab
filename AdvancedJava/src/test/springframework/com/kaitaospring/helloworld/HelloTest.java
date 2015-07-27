package com.kaitaospring.helloworld;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloTest {

	@Test
	public void testHelloWorld() {
		// 1. Read the configuration file and construct an IoC container
		ApplicationContext context = new ClassPathXmlApplicationContext("hellospring.xml");
		
		// 2. Get bean from the container, notice programming to interface instead of programming to the implementation.
		HelloApi helloApi = context.getBean("hello", HelloApi.class);
		
		// 3. Execute the business logic
		helloApi.sayHello();
		
		HelloApi bean1 = context.getBean("bean1", HelloApi.class);
		bean1.sayHello();

		String[] aliases = context.getAliases("bean1");
		for(String aliase : aliases) {
			System.out.println(aliase);
		}
		assertEquals(1, aliases.length);
	}
	
	@Test
	public void testInitializeWithConstructArgs() {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("hellospring.xml");
		
		HelloApi hello2 = beanFactory.getBean("hello2", HelloApi.class);
		hello2.sayHello();
	}
	
	@Test 
	public void testInitializeWithStaticFactory() {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("hellospring.xml");
		
		HelloApi hello3 = beanFactory.getBean("staticFactory", HelloApi.class);
		hello3.sayHello();
	}
	
	@Test
	public void testInitializeWithInstanceFactory() {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("hellospring.xml");
		
		HelloApi hello4 = beanFactory.getBean("hello3", HelloApi.class);
		hello4.sayHello();
	}
}
