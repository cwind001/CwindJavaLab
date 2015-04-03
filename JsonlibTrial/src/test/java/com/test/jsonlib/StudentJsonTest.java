package com.test.jsonlib;

import com.cwind.jsonlib.Basketball;
import com.cwind.jsonlib.Birthday;
import com.cwind.jsonlib.Sport;
import com.cwind.jsonlib.Student;
import com.cwind.jsonlib.Swimming;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

public class StudentJsonTest {
	public static void main(String[] args){
		
		/**
		 * From bean to jsonobject
		 */
		
		JsonConfig config = new JsonConfig();  
        config.setIgnoreDefaultExcludes(true);  //默认为false，即过滤默认的key  
		
		Student stu1 = new Student();
		stu1.setAddress("Paradise Building, HZ");
		stu1.setBirthday(new Birthday("Nov22,2012"));
		stu1.setEmail("wchen@angel.com");
		stu1.setId(10419);
		stu1.setName("Billy Chen");
		stu1.setSport(new Basketball());
		JSONObject jsonobj1=JSONObject.fromObject(stu1, config);
		System.out.println(jsonobj1.toString());
		Student stu2 = new Student();
		stu2.setAddress("Paradise Building, HZ");
		stu2.setBirthday(new Birthday("Nov22,2012"));
		stu2.setEmail("wchen@angel.com");
		stu2.setId(10419);
		stu2.setName("Billy Chen");
		stu2.setSport(new Swimming());
		JSONObject jsonobj2=JSONObject.fromObject(stu2);
		System.out.println(jsonobj2.toString());
		Student stu3 = new Student();
		stu3.setAddress("Paradise Building, HZ");
		stu3.setBirthday(new Birthday("Nov22,2012"));
		stu3.setEmail("wchen@angel.com");
		stu3.setId(10419);
		stu3.setName("Billy Chen");
		JSONObject jsonobj3=JSONObject.fromObject(stu3);
		System.out.println(jsonobj3.toString());
		Birthday birthday1 = new Birthday();
		birthday1.setBirthday("Mar26, 1986");
		JSONObject jsonobj4=JSONObject.fromObject(birthday1);
		System.out.println(jsonobj4.toString());
		/**
		 * From jsonobject to bean
		 */
//		Student genStu1 = (Student) JSONObject.toBean(jsonobj1, Student.class);
//		Student genStu2 = (Student) JSONObject.toBean(jsonobj2, Student.class);
//		Student genStu3 = (Student) JSONObject.toBean(jsonobj3, Student.class);
//		genStu1.getSport().printSport();
//		genStu2.getSport().printSport();
//		System.out.println(genStu3.toString());
		Birthday genBirthday1 = (Birthday) JSONObject.toBean(jsonobj4, Birthday.class);
		System.out.println(genBirthday1.toString());
	}
}
