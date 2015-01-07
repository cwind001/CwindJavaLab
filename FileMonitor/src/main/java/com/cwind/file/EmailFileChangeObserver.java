package com.cwind.file;

public class EmailFileChangeObserver implements FileChangeObserver {

	private String email;
	
	public EmailFileChangeObserver(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public void fileChanged(String filename) {
		System.out.println("File " + filename + " is changed, will send email to " + email +".");		
	}

}
