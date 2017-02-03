package org.cripac.isee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping(value="loginer")
	public String forwardlogin(){
		
		return "login";
	}
	
	@RequestMapping(value="register")
	public String forwardreg(){
		
		return "register";
	}
}
