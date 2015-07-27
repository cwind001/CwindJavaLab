package com.kaitaospring.helloworld;

public class HelloBeanStaticFactory {

	public static HelloApi getHelloImpl2(String message) {
		return new HelloImpl2(message);
	}
}
