package com.kaitaospring.ch3.di;

import java.io.IOException;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DependencyInjectTest {
	
	@Test
	public void testDependOn() throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springch3di.xml");
		context.registerShutdownHook();
		DependentBean dependentBean = context.getBean("dependentBean", DependentBean.class);
		dependentBean.write("test");
	}

}
