package com.cwind.inherit;

public class InstanceOfTest {
	public static void main(String[] args){
		Person p1 = new Person();
		Student s1 = new Student();
		Teacher t1 = new Teacher();
		System.out.println(p1 instanceof Person);
		System.out.println((s1 instanceof Person)&&(!(s1 instanceof Student)));
		System.out.println((p1 instanceof Person)&&(!(p1 instanceof Student)));
	}
}
