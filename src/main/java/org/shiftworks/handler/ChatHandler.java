package org.shiftworks.handler;

/**
* Version : 1.0
* 파일명: ChattingHandler.java
* 작성일자 : 2022-10-29
* 작성자 : 권해림
* @see 
* 설명 : 채팅을 위한 핸들러, TextWebSocketHandler를 상속 받아 구현한다.
* 		핸들러 클래스를 구현해야 클라이언트 관리를 할 수 있다. 1:n 채팅이 가능하도록 구현함.
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.log4j.Log4j;

@Log4j
public class ChatHandler extends TextWebSocketHandler {
	
	private Vector<WebSocketSession> sessionVector = new Vector<WebSocketSession>();
	
	
	/**
	* public void afterConnectionEstablished(WebSocketSession session) throws Exception
	* 설명 : 채팅을 위해 해당 페이지에 들어오면 ('/message/echo') 클라이언트가 연결된 후
	* 		클라이언트 세션을 sessionList에 add 함.
	* @param session : '/message/echo'에 접속한 user
	* @throws NullPointException 세션객체가 Null일 때 발생
	*/
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		
		log.info("#ChattingHandler, afterConnectionEstablished");
		
		sessionVector.add(session);
		
		log.info(session.getId() + "님이 입장하셨습니다.");
		//log.info(session.getPrincipal().getName() + "님이 입장하셨습니다."); 
		super.afterConnectionEstablished(session);
	}
	
	
	/**
	* protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception
	* 설명 : 웹 소켓 서버로 메세지를 전송했을 때 호출되는 메서드.
	* 		현재 웹 소켓 서버에 접속한 Session 모두에게 메세지를 전달해야하므로 loop를 돌며 메세지를 전송한다.
	* @param session : '/message/echo'에 접속한 user
	* @param message : user가 전송한 메세지 내용
	* @throws NullPointException 세션객체가 Null일 때 발생
	*/
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
		log.info("#ChattingHandler, handleTextMessage");
		log.info(session.getId() + ": " + message);
		
//		for(WebSocketSession webSocketSession : sessionVector) {
//			webSocketSession.sendMessage(new TextMessage(session.getPrincipal().getName() + ":" + message.getPayload()));
//		}
		
		for(WebSocketSession webSocketSession : sessionVector) {
			webSocketSession.sendMessage(new TextMessage(session.getId() + ":" + message.getPayload()));
		}
	}
	
	/**
	* public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception
	* 설명 : 클라이언트와 연결이 끊어진 경우 (채팅방을 나간 경우) remove로 해당 세션을 제거한다.
	* @param session : '/message/echo'에 접속한 user
	* @param status : user 연결 상태
	* @throws NullPointException 세션객체가 Null일 때 발생
	*/
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		
		log.info("#ChattingHandler, afterConnectionClosed");
		log.info("closeStatus : " + closeStatus);
		sessionVector.remove(session);
		
		log.info(session.getId() + "님이 퇴장하셨습니다.");
		//log.info(session.getPrincipal().getName() + "님이 퇴장하셨습니다.");
	}
}
