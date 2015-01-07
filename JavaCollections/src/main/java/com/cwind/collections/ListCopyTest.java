package com.cwind.collections;

import java.util.ArrayList;
import java.util.Arrays;

public class ListCopyTest {
	public static void main(String[] args){
		ArrayList<Student> al = new ArrayList<Student>();
		Student stu1 = new Student("test1");
		Student stu2 = new Student("test2");
		Student stu3 = new Student("test3");
		al.add(stu1);
		al.add(stu2);
		al.add(stu3);
		
		ArrayList<Student> al2 = new ArrayList<Student>();
		al2.addAll(al);
		for(Student stu : al2) {
			System.out.println(stu.getName());
		}
		stu1.setName("Echo");
		for(Student stu : al2) {
			System.out.println(stu.getName());
		}
		
		Student[] array = {stu1, stu2, stu3};
		Student[] array2 = Arrays.copyOf(array, array.length);
		for(Student stu : array2) {
			System.out.println(stu.getName());
		}
		stu1.setName("Anna");
		for(Student stu : array2) {
			System.out.println(stu.getName());
		}
	}
}

class Student{
	String name;
	
	public Student() {
		this.name = "default";
	}

	public Student(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
