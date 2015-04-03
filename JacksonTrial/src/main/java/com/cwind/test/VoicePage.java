package com.cwind.test;

public class VoicePage {
	private String id;
	private String name;
	private String desc;
	private String parenetGroupId;
	private String domainCode;
	public VoicePage(){
		
	}
	public VoicePage(String id, String name, String desc,
			String parenetGroupId, String domainCode) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.parenetGroupId = parenetGroupId;
		this.domainCode = domainCode;
	}
	public String getDomainCode() {
		return domainCode;
	}
	public void setDomainCode(String domainCode) {
		this.domainCode = domainCode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getParenetGroupId() {
		return parenetGroupId;
	}
	public void setParenetGroupId(String parenetGroupId) {
		this.parenetGroupId = parenetGroupId;
	}

}
