package org.shiftworks.domain;

/**
 * private한 공간에서 채팅할 수 있도록 채팅방 만듦
 */

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.web.socket.WebSocketSession;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ChatRoomDTO {
	
	private String room_id;
	private String room_name;
	private String lastchat;
	private String lastchat_time;
	private String emp_id;
	private String dept_id;
	
	// WebSocketSession은 spring에서 Websocket connection이 맺어진 세션
	private Set<WebSocketSession> session = new HashSet<>();
	
	public ChatRoomDTO() {
		this.room_id = UUID.randomUUID().toString();
	}

	public ChatRoomDTO(String room_name, String emp_id, String dept_id) {
		super();
		this.room_id = UUID.randomUUID().toString();
		this.room_name = room_name;
		this.emp_id = emp_id;
		this.dept_id = dept_id;
	}
}
