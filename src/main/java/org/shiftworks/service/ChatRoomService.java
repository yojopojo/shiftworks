package org.shiftworks.service;

import java.util.List;

import org.shiftworks.domain.ChatRoomDTO;
import org.shiftworks.domain.ChatRoomVO;

public interface ChatRoomService {
	List<ChatRoomVO> getList(String emp_id);
	Integer insertChatRoom(ChatRoomDTO chatRoom);
}
