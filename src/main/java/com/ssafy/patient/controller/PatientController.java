package com.ssafy.patient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PatientController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";//jsp 호출
	}
	
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public String regist() {
		return "regist";//jsp 호출
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search() {
		return "list";//jsp 호출
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String get(int no) {
		return "redirect:/patient/"+no;
	}
}
