package org.shiftworks.domain;

import java.util.UUID;

import lombok.Data;

@Data
public class ChatRoomVO {
	private String room_id;
	private String room_name;
	private String lastchat;
	private String lastchat_time;
	private String emp_id;
	private String dept_id;
	
	public static ChatRoomVO create(String name) {
		ChatRoomVO chatRoom = new ChatRoomVO();
		chatRoom.room_id = UUID.randomUUID().toString();
		chatRoom.room_name = name;
		return chatRoom;
	}
	
}
