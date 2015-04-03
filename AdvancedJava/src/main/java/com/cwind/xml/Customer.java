package com.cwind.xml;

import java.util.List;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlType(propOrder = { "phoneNumbers", "name"})
public class Customer extends Person{
	private String password;
	private List<String> phoneNumbers;
	@XmlTransient
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@XmlElement(name="phone-number")
	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	
}
