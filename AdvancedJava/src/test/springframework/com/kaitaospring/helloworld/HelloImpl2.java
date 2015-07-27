package com.kaitaospring.helloworld;

public class HelloImpl2 implements HelloApi {

	private String message;
	
	public HelloImpl2(){
		message = "Default message in HelloImpl2";
	}
	
	public HelloImpl2(String message){
		this.message = message;
	}
	
	@Override
	public void sayHello() {
		System.out.println(message);
	}

}
