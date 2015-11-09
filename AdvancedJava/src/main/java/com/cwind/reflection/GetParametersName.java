package com.cwind.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class GetParametersName {

	public String getResultByUserId(long userId) {
		return "User name: " + userId;
	}
	
	public String getResultByOpIdAndFundId(long opId, long fundId) {
		return "OpId: " + opId + ", fundId: "+ fundId;
	}
	
	public static void main(String[] args) {
		GetParametersName tester = new GetParametersName();
		Class cls = tester.getClass();
		Method[] methods = cls.getMethods();
		for(Method method : methods){
			if("getResultByUserId".equals(method.getName())||"getResultByOpIdAndFundId".equals(method.getName())){
				System.out.println(method.getName());
				System.out.println(method.getParameterCount());	
				Parameter[] parameters = method.getParameters();
				for(Parameter parameter : parameters){
					System.out.println(parameter.getName()+", type: "+parameter.getType());
				}
				
			}
		}
	}
}
