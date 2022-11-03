package org.shiftworks.controller;

<<<<<<< HEAD
=======
<<<<<<< HEAD

=======
>>>>>>> 48babc45ad899a002b86d9ea5b08aff601049fa6
>>>>>>> refs/remotes/origin/feature-mgt
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
=======
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PostMapping;
>>>>>>> refs/remotes/origin/feature-mgt

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

<<<<<<< HEAD
}
=======
	
=======

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class CommonController {
	
	// 濡쒓렇�씤 �븘�슂 �떆 而ㅼ뒪��� 濡쒓렇�씤 �럹�씠吏�濡� �씠�룞
	@GetMapping("/customLogin")
	public void loginInput(String error, String logout, Model model) {
		log.info("error: " + error + ", logout:" + logout);
		
		// �뿉�윭 諛쒖깮 �떆 view�뿉 硫붿떆吏� �쟾�떖
		if(error != null) {
			model.addAttribute("error", "Login Error");
		}
		
		// 濡쒓렇�븘�썐 �떆 view�뿉 硫붿떆吏� �쟾�떖
		if(logout != null) {
			model.addAttribute("logout", "Logout");
		}
	}
	
	// 濡쒓렇�븘�썐 �떆 荑좏궎, �꽭�뀡 �궘�젣 �쑀�룄(�떎�젣 �옉�뾽��� �뒪�봽留� �궡遺��뿉�꽌!)
	@GetMapping("/customLogout")
	public void logoutGET() {
		log.info("custom Logout");
	}
	
	
	// �젒洹� 沅뚰븳�씠 �뾾�뒗 �럹�씠吏��뿉 �젒洹� �떆 �젒洹� 遺덇�� �럹�씠吏� 異쒕젰
	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		log.info("access Denied: " + auth);
		
		// view�뿉 �젒洹� 遺덇�� 硫붿떆吏� �쟾�떖
		model.addAttribute("message", "Access Denied");
	}

>>>>>>> 48babc45ad899a002b86d9ea5b08aff601049fa6
}
>>>>>>> refs/remotes/origin/feature-mgt
