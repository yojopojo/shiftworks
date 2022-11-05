package org.shiftworks.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatVO {
	private Integer chat_id;
	private String content;
	private String sendtime;
	private String sender;	// 보낸 사람 사번
	private Integer room_id;
}
