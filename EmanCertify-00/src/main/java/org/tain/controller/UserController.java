package org.tain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {
	
	
	@RequestMapping(value = {"/user/login"}, method = {RequestMethod.GET, RequestMethod.POST})
	public String userlogin() {
		
		return "user/login";
	}
	
	@RequestMapping(value = {"/user/loginsuccess"}, method = {RequestMethod.GET, RequestMethod.POST})
	public String userloginsuccess() {
		
		return "user/loginsuccess";
	}
	
	@RequestMapping(value = {"/user/loginfail"}, method = {RequestMethod.GET, RequestMethod.POST})
	public String userloginfail() {
		
		return "user/loginfail";
	}
}

