package org.shiftworks.service;

import java.util.List;

import org.shiftworks.domain.ChatRoomVO;
import org.shiftworks.domain.ChatVO;

public interface ChatService {
	List<ChatRoomVO> getChatRoomList(String emp_id);
	List<ChatVO> getChatList(Integer room_id);
}
