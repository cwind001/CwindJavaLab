package com.cwind.dynamicproxy;

public class ServiceImpl implements IService{

	public void sayHello(){
		System.out.println("Hello!");
	}
	
	public void sayBye() {
		System.out.println("Bye!");
	}

	@Override
	public void goToSchool() {
		System.out.println("Go to School.");
	}
}
