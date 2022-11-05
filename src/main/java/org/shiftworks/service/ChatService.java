package org.shiftworks.service;

import java.util.List;

import org.shiftworks.domain.ChatRoomVO;
import org.shiftworks.domain.ChatVO;
import org.shiftworks.domain.ChatDTO;

public interface ChatService {
	List<ChatRoomVO> getChatRoomList(String emp_id);
	List<ChatDTO> getChatList(Integer room_id);
	Integer sendChat(ChatVO chat);
}
