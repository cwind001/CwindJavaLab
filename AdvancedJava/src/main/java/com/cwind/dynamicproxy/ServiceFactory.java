package com.cwind.dynamicproxy;

public class ServiceFactory {

	public static void before() {
		System.out.println("前置日志：打印、启动事务等……");
	}
	
	public static void after() {
		System.out.println("后置日志：打印、关闭事务等……");
	}
	
	public static void other() {
		System.out.println("做其他的事……");
	}
	
}
