package org.shiftworks.controller;

/**
 * @MessageMapping 을 통해 WebSocket으로 들어오는 메세지 발행을 처리한다.
 * Client에서는 prefix를 붙여 "/pub/messenger/chat/enter"로 발행 요청을 하면 Controller가 해당 메세지를 받아 처리하는데, 
 * 메세지가 발행되면 "/sub/messenger/chat/room/[roomId]"로 메세지가 전송되는 것을 볼 수 있다.
 * Client에서는 해당 주소를 SUBSCRIBE하고 있다가 메세지가 전달되면 화면에 출력한다. 
 * 이때 /sub/messenger/chat/room/[roomId]는 채팅방을 구분하는 값이다.
 * 핸들러 역할을 대신함.
 */

import org.shiftworks.domain.ChatVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class StompChatController {
	
	// 특정 Broker로 메세지를 전달
	private SimpMessagingTemplate simpMessagingTemplate;
	
	// client가 send할 수 있는 경로
	// servlet-context.xml에서 설정한 application-destination-prefix와 @messageMapping 경로가 병합
	// "pub/messenger/chat/enter"
	@MessageMapping("messenger/chat/enter")
	public void enterChatRoom(ChatVO chat) {
		// 입장했을 때 
		chat.setContent(chat.getSender() + "님이 채팅방에 참여하였습니다.");
		simpMessagingTemplate.convertAndSend("/sub/messenger/chat/room/" + chat.getRoom_id(), chat);
	}
	
	
	@MessageMapping("/messenger/chat/message")
	public void sendChat(ChatVO chat) {
		// 채팅 전송
		simpMessagingTemplate.convertAndSend("/sub/messneger/chat/room/" + chat.getRoom_id(), chat);
	}
	
	
	@MessageMapping("/stomp")
	@SendTo("/topic/stomp")
	public ResponseEntity<String> stomp(String request) {
		return new ResponseEntity<String>(request, HttpStatus.OK);
	}
	
	
}
