package com.kaitaospring.ch3.di;

import java.io.IOException;

public class DependentBean {
	ResourceBean resourceBean;
	
	public void init() throws IOException{
		System.out.println("DependentBean:-----init");
		resourceBean.getFos().write("DependentBean:-----init-----".getBytes());;
	}
	
	public void write(String ss) throws IOException {
		System.out.println("DependentBean:-----write resource");
		resourceBean.getFos().write(ss.getBytes());
	}
	
	public void destroy() throws IOException {
		System.out.println("DependentBean:-----destroy");
		resourceBean.getFos().write("DependentBean:-----destroy-----".getBytes());
	}
	
	public void setResourceBean(ResourceBean resourceBean) {
		this.resourceBean = resourceBean;
	}
}
