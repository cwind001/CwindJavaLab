package com.cwind.system;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestLoadPropertiesFromFile {
	public static void main(String[] args) throws IOException {
		// If path doesn't start with '/', will load resource from current package. If there is '/' will load from class path root.
		InputStream is = TestLoadPropertiesFromFile.class.getResourceAsStream("/test.properties"); 
		
		Properties props = new Properties();
		props.load(is);
		System.out.println(props.get("sun.cpu.isalist"));
		System.out.print(props.get("dummy"));
	}
}
