package com.cwind.xml;

import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
public class Person extends Base{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
