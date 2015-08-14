package com.cwind.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BeanUtils {
	public static Map<String, Object> backupProp(Object/* bean to backup */ bean) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
			PropertyDescriptor[] properties = beanInfo.getPropertyDescriptors();
			for(PropertyDescriptor property : properties){
				String fieldName = property.getName();
				Method getMethod = property.getReadMethod();
				Object fieldValue = getMethod.invoke(bean, null);
				if(!fieldName.equalsIgnoreCase("class")){
					result.put(fieldName, fieldValue);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void restoreProp(Object bean, Map<String, Object> props) {
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
			PropertyDescriptor[] properties = beanInfo.getPropertyDescriptors();
			for(PropertyDescriptor property : properties) {
				String fieldName = property.getName();
				if(props.containsKey(fieldName)){
					Method writeMethod = property.getWriteMethod();
					writeMethod.invoke(bean, props.get(fieldName));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
