package com.effective.java;

import java.util.HashSet;
import java.util.Set;

public class EqualsTest {
	public int intValue;
	public String strValue;
	
	public EqualsTest(){
		intValue = 0;
		strValue = "";
	}
	
//	@Override
//	public boolean equals(Object et){
//		if(et==this){
//			return true;
//		}
//		if(!(et instanceof EqualsTest)){
//			return false;
//		}
//		EqualsTest eto = (EqualsTest) et;
//		return eto.intValue == intValue && eto.strValue.equals(strValue);
//	}
	
	public boolean equals(EqualsTest et){
		return true;
	}
	
	@Override
	public int hashCode(){
		int result = 17;
		result += 31 * result + intValue;
		result += 31 * result + (strValue != null ? strValue.hashCode() : 0);
		return result;
	}
	
	public static void main(String[] args) {
		Set<EqualsTest> set = new HashSet<>();
		EqualsTest t1 = new EqualsTest();
		EqualsTest t2 = new EqualsTest();
		Object obj = t2;
		System.out.println(t1.equals(t2));
		System.out.println(t1.equals(obj));
		System.out.println(t1.hashCode() + ", " + t2.hashCode());
		set.add(t1);
		set.add(t2);
		System.out.println(set.size());
		
	}
}
