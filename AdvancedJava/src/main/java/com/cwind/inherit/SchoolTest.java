package com.cwind.inherit;

public class SchoolTest {
	public static void main(String[] args){
		School university = new School("Nanjing University", "Hankou Road 22#");
		Student stu1 = new Student();
		Teacher tea1 = new Teacher();
		stu1.setUniversity(university);
		tea1.setUniversity(university);
		System.out.println(stu1.getUniversity().getName());
		university.setName("Zhejiang University");
		stu1.getUniversity().setName("Tsinghua University");
		System.out.println(tea1.getUniversity().getName());
	}
}
