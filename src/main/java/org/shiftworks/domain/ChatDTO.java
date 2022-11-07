package org.shiftworks.domain;

import lombok.Data;

@Data
public class ChatDTO {
	
	private Integer chat_id;
	private String content;
	private String sendtime;
	private String sender;	// 보낸 사람 사번
	private Integer room_id;
	
	private ChatRoomVO chatRoom;
}
