package org.shiftworks.domain;

import lombok.Data;

@Data
public class ChatRoomDTO {
	
	private int room_id;
	private String room_name;
	private String lastchat;
	private String lastchat_time;
	private String emp_id;
	private String dept_id;
	
}
