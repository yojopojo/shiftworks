package org.shiftworks.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageVO {
	private int msg_id;
	private char notice;
	private char important;
	private String content;
	private String time;
	private String sender;
}
