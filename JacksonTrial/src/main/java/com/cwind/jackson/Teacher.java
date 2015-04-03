package com.cwind.jackson;

import org.codehaus.jackson.annotate.JsonIgnore;

public abstract class Teacher {
	public abstract String getTeacherInfo();
	private int _age;
	public int get_age() {
		return _age;
	}
	
	public void set_age(int _age) {
		this._age = _age;
	}
	
	public void set_age(String _age){
		this._age = Integer.parseInt(_age);
	}
	
}
