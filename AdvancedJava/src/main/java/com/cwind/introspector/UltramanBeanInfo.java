package com.cwind.introspector;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;


public class UltramanBeanInfo extends SimpleBeanInfo {
	public PropertyDescriptor[] getPropertyDescriptors() {
		try {
			return new PropertyDescriptor[]{
				new PropertyDescriptor("avanta", Ultraman.class),
				new PropertyDescriptor("name", Ultraman.class)
			};
		} catch (IntrospectionException e) {
			e.printStackTrace();
			return null;
		}
	}
}
