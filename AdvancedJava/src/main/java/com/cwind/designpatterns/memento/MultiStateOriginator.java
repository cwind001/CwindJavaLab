package com.cwind.designpatterns.memento;

import com.cwind.util.BeanUtils;

public class MultiStateOriginator {
	String name;
	int age;
	String gender;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public MultiStateMemento createMemento() {
		return new MultiStateMemento(BeanUtils.backupProp(this));
	}

	public void restoreMemento(MultiStateMemento memento) {
		BeanUtils.restoreProp(this, memento.getCache());
	}

	@Override
	public String toString() {
		return "MultiStateoriginator [name=" + name + ", age=" + age
				+ ", gender=" + gender + "]";
	}
}
