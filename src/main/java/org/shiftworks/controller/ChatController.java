///**
//* Version : 1.0
//* 파일명: MessengerController.java
//* 작성일자 : 2022-10-29	
//* 작성자 : 권해림
//* 설명 : 채팅과 관련된 모든 요청을 받는 컨트롤러
//*/
//
//package org.shiftworks.controller;
//
//
//import java.util.List;
//
//import org.shiftworks.domain.ChatRoomVO;
//import org.shiftworks.domain.ChatVO;
//import org.shiftworks.domain.ChatDTO;
//import org.shiftworks.service.ChatService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//
//import lombok.extern.log4j.Log4j;
//
//
//
//
//@Log4j
//@RequestMapping("/messenger")
//public class ChatController {
//	
//	@Autowired
//	ChatService chatService;
//	
//	// 메신저 실행 : 채팅방 목록 보여줌
//	@PreAuthorize("isAuthenticated()")
//	@GetMapping("/chat")
//	public String chat(Model model, Authentication auth) {
//		
//		UserDetails userDetails = (UserDetails) auth.getPrincipal();
//		log.info("@ChatController, GET Chat / Username : " + userDetails.getUsername());
//
//		List<ChatRoomVO> chatRoomList = chatService.getChatRoomList(userDetails.getUsername());
//		// List<ChatDTO> chatList = chatService.getChatList(1);
//		
//		model.addAttribute("chatRoomList", chatRoomList);
//		//model.addAttribute("chatList", chatList);
//
////		CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
////		
////		log.info("==================================");
////		log.info("@ChatController, GET Chat / Username : " + user.getUsername());
////		
////		model.addAttribute("userid", user.getUsername());
//		
//		return "messenger/MSG_main";
//	}
//	
//	// 선택된 채팅방의 정보 요청
//	@GetMapping("/chat/room/{room_id}")
//	@PreAuthorize("isAuthenticated()")
//	@ResponseBody
//	public ResponseEntity<List<ChatDTO>> getChat(@PathVariable("room_id") Integer room_id){
//		log.info("@ChatController, GET getChat...............");
//		return new ResponseEntity<>(chatService.getChatList(room_id), HttpStatus.OK);
//	}
//	
//	// 메시지 전송 요청
//	@PostMapping(value="/send", produces=MediaType.TEXT_PLAIN_VALUE)
//	@ResponseBody
//	public ResponseEntity<String> sendChat(@RequestBody ChatVO chat){
//		log.info("@ChatController, POST sendMessage...............");
//		
//		
//		Integer sendResult = chatService.sendChat(chat);
//		Integer updateResult = chatService.updateLastChat(chat);
//		
//		Integer result = (sendResult == 1 && updateResult == 1) ? 1 : -1;
//		
//		// insert 유무에 따라 헤더값을 다르게 전달
//		return result == 1 ? new ResponseEntity<>("success", HttpStatus.OK) // 200
//						: new ResponseEntity<>("fail", HttpStatus.INTERNAL_SERVER_ERROR); // 500
//	}
//}
