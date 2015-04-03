package com.cwind.htcc;

/*
 * dafeng 8/26/2013
 * 
 * */
public class HTCCRestResponse {
	
	
	private int statusCode =1;
	
	
	private HTCCUser user;
	
	private String statusMessage;
	
	private String uri;

	
	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}


	public HTCCUser getUser() {
		return user;
	}

	public void setUser(HTCCUser user) {
		this.user = user;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
	
	public HTCCRestResponse(){
		user = new HTCCUser();
	}
	
	

}
