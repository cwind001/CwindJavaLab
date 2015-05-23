package com.effective.java;

import java.util.HashMap;

public class HeterogeneousMap {
	private HashMap<Class<?>, Object> map = new HashMap<Class<?>, Object>();
	
	public <T> void putObject(Class<T> cls, Object obj) {
		if(cls == null) {
			throw new NullPointerException("Type is null");
		}
		map.put(cls, cls.cast(obj));
	}
	
	public <T> T getObject(Class<T> cls) {
		T obj = cls.cast(map.get(cls));
		return obj;
	}
	
	public static void main(String[] args) {
		HeterogeneousMap hMap = new HeterogeneousMap();
		hMap.putObject(String.class, "Java");
		hMap.putObject(Integer.class, 0xabc);
		hMap.putObject(Class.class, hMap.getClass());
		String str = hMap.getObject(String.class);
		Integer i = hMap.getObject(Integer.class);
		Class cls = hMap.getObject(Class.class);
		
		System.out.printf("%s %x %s", str, i, cls.getName());
	}
}
