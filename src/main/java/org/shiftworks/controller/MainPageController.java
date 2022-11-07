package org.shiftworks.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/login")
@Log4j
public class MainPageController {
	
	@GetMapping
	public String main(Model model) {
	
		//파라미터로 @AuthenticationPrincipal 어노테이션 통해서 
		//UserDetails 인터페이스를 구현한 SecurityUser객체 속에 들어있는
		//principal필드(인증ID)를 가져올 수 있다.
		//@AuthenticationPrincipal UserDetailsimpl userDetails
		
		return null;//로그인 후 인증된 username정보가 담긴 empVO객체를
		//"메인페이지 url"에 전달하며 넘어간다.
	}

	@GetMapping("/LOG_main")
	public void doMain() {
	
		log.info("LOGIN MAIN PAGE .............................");
		
	}
	
	@GetMapping("/LOG_user")
	public void doUser() {
		
		log.info("user page.........");
	}
	
	@GetMapping("/LOG_admin")
	public void doAdmin() {
		log.info("admin only...........");
	}
	
}
