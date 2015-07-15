package com.cwind.string;

import java.util.regex.Pattern;

public class IsStringNumericTest {
	public static void main(String[] args){
		System.out.println(isInteger("0"));
		System.out.println(isInteger("100"));
		System.out.println(isInteger("-1"));
		System.out.println(isInteger("1d3"));
		System.out.println(isInteger("-"));
		System.out.println(isInteger("+"));
	}
	
	public static boolean isInteger(String str) {    
	    Pattern pattern = Pattern.compile("^[-\\+]?[\\d]+$");    
	    return pattern.matcher(str).matches();    
	}  
}
