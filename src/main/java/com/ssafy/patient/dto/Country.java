package com.ssafy.patient.dto;

public class Country {
	private String ccode;
	private String cname;
	public Country(String ccode, String cname) {
		super();
		this.ccode = ccode;
		this.cname = cname;
	}
	public String getCcode() {
		return ccode;
	}
	public void setCcode(String ccode) {
		this.ccode = ccode;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	
}
