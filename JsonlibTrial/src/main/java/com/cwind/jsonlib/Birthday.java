package com.cwind.jsonlib;

public class Birthday {
	
	private String birthday;
    
    public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public Birthday(String birthday) {
        super();
        this.birthday = birthday;
    }
    //setter、getter
    public Birthday() {}
    
    @Override
    public String toString() {
        return this.birthday;
    }

}
