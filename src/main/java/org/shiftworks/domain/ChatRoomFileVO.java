package org.shiftworks.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatRoomFileVO {
	private String uuid;
	private int msg_id;
	private String file_name;
	private String file_src;
}
