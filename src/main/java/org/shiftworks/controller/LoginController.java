package org.shiftworks.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/login")
@Log4j
public class LoginController {

	@GetMapping("/main")
	public void doMain() {
	
		log.info("LOGIN MAIN PAGE .............................");
		
	}
	
	@GetMapping("/user")
	public void doUser() {
		
		log.info("user page.........");
	}
	
	@GetMapping("/admin")
	public void doAdmin() {
		log.info("admin only...........");
	}
	
}
