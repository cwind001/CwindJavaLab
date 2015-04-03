package com.cwind.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.*;

public class Demo {
	
	public static void main(String[] args) throws Exception{
		JAXBContext jc = JAXBContext.newInstance(Customer.class);
		
//		Unmarshaller unmarshaller = jc.createUnmarshaller();
//		File xml = new File("input.xml");
//		Customer customer = (Customer) unmarshaller.unmarshal(xml);
		Customer customer = new Customer();
		customer.setName("Alizee");
		customer.setPassword("1234QWER");
		List<String> phoneNumberList = new ArrayList<String>();
		phoneNumberList.add("7135551010");
		phoneNumberList.add("7135551011");
		customer.setPhoneNumbers(phoneNumberList);
		
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(customer, System.out);
	}
}
