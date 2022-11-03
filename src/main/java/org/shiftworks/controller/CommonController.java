package org.shiftworks.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class CommonController {
	
	// 로그인 필요 시 커스텀 로그인 페이지로 이동
	@GetMapping("/customLogin")
	public void loginInput(String error, String logout, Model model) {
		log.info("error: " + error + ", logout:" + logout);
		
		// 에러 발생 시 view에 메시지 전달
		if(error != null) {
			model.addAttribute("error", "Login Error");
		}
		
		// 로그아웃 시 view에 메시지 전달
		if(logout != null) {
			model.addAttribute("logout", "Logout");
		}
	}
	
	// 로그아웃 시 쿠키, 세션 삭제 유도(실제 작업은 스프링 내부에서!)
	@GetMapping("/customLogout")
	public void logoutGET() {
		log.info("custom Logout");
	}
	
	
	// 접근 권한이 없는 페이지에 접근 시 접근 불가 페이지 출력
	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		log.info("access Denied: " + auth);
		
		// view에 접근 불가 메시지 전달
		model.addAttribute("message", "Access Denied");
	}

}
