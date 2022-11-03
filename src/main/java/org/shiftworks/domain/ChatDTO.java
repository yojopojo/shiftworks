package org.shiftworks.domain;

import lombok.Data;

@Data
public class ChatDTO {
	
	private int chat_id;
	private String content;
	private String sendtime;
	private String sender;	// 보낸 사람 사번
	private int room_id;
	private int room_name;
	
	private ChatRoomVO chatRoom;
}
