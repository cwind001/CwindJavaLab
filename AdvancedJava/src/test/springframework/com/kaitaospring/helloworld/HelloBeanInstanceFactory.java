package com.kaitaospring.helloworld;

public class HelloBeanInstanceFactory {
	public HelloApi getHelloImpl2(String message){
		return new HelloImpl2(message);
	}
}
