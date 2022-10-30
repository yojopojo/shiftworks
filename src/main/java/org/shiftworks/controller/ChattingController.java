/**
* Version : 1.0
* 파일명: MessengerController.java
* 작성일자 : 2022-10-29	
* 작성자 : 권해림
* 설명 : 채팅과 관련된 모든 요청을 받는 컨트롤러
*/

package org.shiftworks.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;



@Controller
@Log4j
public class ChattingController {

	@GetMapping("/messenger/echo")
	public String chat(Model model) {
		
//		CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		
//		
//		log.info("==================================");
//		log.info("@ChatController, GET Chat / Username : " + user.getUsername());
//		
//		model.addAttribute("userid", user.getUsername());
		
		return "MSG_main";
	}
}
