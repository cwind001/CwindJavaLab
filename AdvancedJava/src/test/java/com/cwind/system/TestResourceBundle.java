package com.cwind.system;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestResourceBundle {
	public static void main(String[] args) {
		ResourceBundle rb = ResourceBundle.getBundle("test");
		String s = rb.getString("sun.desktop");
		System.out.println(s);
		
		Locale locale1 = new Locale("zh", "CN");
		ResourceBundle resb1 = ResourceBundle.getBundle("test", locale1);
		System.out.println(resb1.getString("key1"));
		
		ResourceBundle resb2 = ResourceBundle.getBundle("test", Locale.getDefault());
		System.out.println(resb2.getString("key1"));
		
		Locale locale2 = new Locale("en", "US");
		ResourceBundle resb3 = ResourceBundle.getBundle("test", locale2);
		System.out.println(resb3.getString("key1"));
	}
}
