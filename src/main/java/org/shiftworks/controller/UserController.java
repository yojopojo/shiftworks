package org.shiftworks.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import lombok.extern.log4j.Log4j;

@RestController
@Log4j
public class UserController {
	

	
	@GetMapping("/accessError")
	public void  accessDenied(Authentication auth, Model model) {
		log.info("access Denied: " + auth);
		model.addAttribute("msg", "Access Denied");
	}
	
	@GetMapping("/LOG_userLogin")
	public void loginInput(String error, String logout, Model model) {
		log.info("error : "+error);
		log.info("logout : "+logout);
		
		if(error != null) {
			model.addAttribute("error", "Login Error Check Your Account");
		}
		
		if(logout != null) {
			model.addAttribute("logout", "Log out!!");
		}
	}
	
	@GetMapping("LOG_userLogout")
	public void logoutGET() {
		
		log.info("user log out.........."  );
	}
	
	
	@GetMapping
	public String homeLogin() {
		return null;
	}
	

	

}
