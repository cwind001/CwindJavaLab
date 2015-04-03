package com.test.jaxb;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.cwind.jsonlib.Basketball;
import com.cwind.jsonlib.Birthday;
import com.cwind.jsonlib.Student;

public class StudentJAXBTest {
	public static void main(String[] args){
		Student stu1 = new Student();
		stu1.setAddress("Paradise Building, HZ");
		stu1.setBirthday(new Birthday("Nov22,2012"));
		stu1.setEmail("wchen@angel.com");
		stu1.setId(10419);
		stu1.setName("Billy Chen");
//		stu1.setSport(new Basketball());
		try{
			System.out.println("Orignal student: "+stu1.toString());
//			stu1.getSport().printSport();
			File file = new File("StudentJAXBdatafile.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	 
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	 
			jaxbMarshaller.marshal(stu1, file);
			jaxbMarshaller.marshal(stu1, System.out);
			
			file = new File("StudentJAXBdatafile.xml");
			jaxbContext = JAXBContext.newInstance(Student.class);
	 
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Student genStu1 = (Student) jaxbUnmarshaller.unmarshal(file);
//			System.out.println("Generated student: "+genStu1.toString());
			
		}catch(JAXBException e){
			e.printStackTrace();
		}
	}
}
