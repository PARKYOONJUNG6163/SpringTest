package com.ssafy.patient.dto;

public class Patient {
	private String pno;
	private String name;
	private int age;
	private String ccode;
	
	
	public Patient(String name, String pno, int age, String ccode) {
		super();
		this.name = name;
		this.pno = pno;
		this.age = age;
		this.ccode = ccode;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCcode() {
		return ccode;
	}
	public void setCcode(String ccode) {
		this.ccode = ccode;
	}
	
	
}
