package org.shiftworks.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatVO {
	
	private int msg_id;
	private char notice;
	private char important;
	private String content;
	private String sendtime;
	private String sender;	// 보낸 사람 사번
	
	private List<ChatRoomVO> receivers;
	
}
