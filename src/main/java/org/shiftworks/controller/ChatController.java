/**
* Version : 1.0
* 파일명: MessengerController.java
* 작성일자 : 2022-10-29	
* 작성자 : 권해림
* 설명 : 채팅과 관련된 모든 요청을 받는 컨트롤러
*/

package org.shiftworks.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.shiftworks.domain.ChatRoomVO;
import org.shiftworks.domain.ChatDTO;
import org.shiftworks.service.ChatService;
import org.shiftworks.service.ChatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;



@Controller
@Log4j
public class ChatController {
	
	@Autowired
	ChatService chatService;

	@GetMapping("/messenger/chat")
	public String chat(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		
		List<ChatRoomVO> chatRoomList = chatService.getChatRoomList("U3948709");
		List<ChatDTO> chatList = chatService.getChatList(1);
		
		model.addAttribute("chatRoomList", chatRoomList);
		model.addAttribute("chatList", chatList);
		
//		CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		
//		log.info("==================================");
//		log.info("@ChatController, GET Chat / Username : " + user.getUsername());
//		
//		model.addAttribute("userid", user.getUsername());
		
		return "MSG_main";
	}
	
	@GetMapping("/messenger/chat/{room_id}")
	@ResponseBody
	public ResponseEntity<List<ChatDTO>> getChat(@PathVariable("room_id") Integer room_id){
		return new ResponseEntity<>(chatService.getChatList(room_id), HttpStatus.OK);
	}
	
//	@PostMapping("/messenger/send")
//	@ResponseBody
//	public ResponseEntity<MessageVO> sendMessage(){
//		
//		
//		
//		return;
//	}
}
