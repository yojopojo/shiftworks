package org.shiftworks.controller;

import java.util.List;

import org.shiftworks.domain.ChatRoomDTO;
import org.shiftworks.domain.ChatRoomVO;
import org.shiftworks.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/messenger/chat")
@Log4j
public class ChatRoomController {

	@Autowired
	private ChatRoomService chatRoomService;

	// 채팅방 목록 조회
	@PreAuthorize("isAuthenticated()")
	@GetMapping("")
	public String chat(Model model, Authentication auth) {

		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		log.info("@ChatRoomController, GET Chat / Username : " + userDetails.getUsername());

		List<ChatRoomVO> chatRoomList = chatRoomService.getList(userDetails.getUsername());
		// List<ChatDTO> chatList = chatService.getChatList(1);

		model.addAttribute("chatRoomList", chatRoomList);
		// model.addAttribute("chatList", chatList);

//			CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//			
//			log.info("==================================");
//			log.info("@ChatController, GET Chat / Username : " + user.getUsername());
//			
//			model.addAttribute("userid", user.getUsername());

		return "messenger/MSG_main";
	}
	
	@PostMapping("/chat/room")
	@PreAuthorize("isAuthenticated()")
	public String createChatRoom(ChatRoomDTO chatRoom , RedirectAttributes rttr) {
		
		log.info("@ChatRoomController, POST createChatRoom");
		
		rttr.addFlashAttribute("room_name", chatRoom);
		return "";
	}

}
