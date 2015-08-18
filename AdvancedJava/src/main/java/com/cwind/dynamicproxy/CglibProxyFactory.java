package com.cwind.dynamicproxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibProxyFactory implements MethodInterceptor {

	private Object target;
	
	public Object bind(Object target) {
		this.target = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.target.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}
	
	@Override
	public Object intercept(Object arg0, Method method, Object[] arg2,
			MethodProxy proxy) throws Throwable {
		ServiceFactory.before();
		Object obj = proxy.invokeSuper(arg0, arg2);
		ServiceFactory.after();
		return obj;
	}

}
