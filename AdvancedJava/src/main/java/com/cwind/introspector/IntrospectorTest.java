package com.cwind.introspector;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

public class IntrospectorTest {
	public static void main(String[] args) throws IntrospectionException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		PropertyDescriptor[] ultramanProps = Introspector.getBeanInfo(Ultraman.class).getPropertyDescriptors();
		Ultraman sailor = new Ultraman("sailor");
		for(PropertyDescriptor prop : ultramanProps){
			System.out.println("Property name: " + prop.getName()+ ", value: "+ prop.getReadMethod().invoke(sailor, null));
		}
		System.out.println();
		for (String path : Introspector.getBeanInfoSearchPath()){
			System.out.println("BeanInfoSearchPath: "+ path);
		}
		PropertyDescriptor[] titanProps = Introspector.getBeanInfo(Titan.class).getPropertyDescriptors();
		Titan titan = new Titan(999,888);
		for(PropertyDescriptor prop : titanProps){
			System.out.println("Property name: " + prop.getName()+ ", value: "+ prop.getReadMethod().invoke(titan, null));
		}
	}
}
