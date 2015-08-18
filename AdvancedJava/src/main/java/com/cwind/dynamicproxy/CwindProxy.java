package com.cwind.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Implement Java Dynamic Proxy
 * @author Cwind
 */
public class CwindProxy implements InvocationHandler {

	private Object delegate;
	
	public Object bind(Object delegate){
		this.delegate = delegate;
		return Proxy.newProxyInstance(this.delegate.getClass().getClassLoader(), this.delegate.getClass().getInterfaces(), this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object obj = null;
		ServiceFactory.before();
		obj = method.invoke(this.delegate, args);
		ServiceFactory.after();
		return obj;
	}

}
