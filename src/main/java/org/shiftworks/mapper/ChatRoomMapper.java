package org.shiftworks.mapper;

import java.util.List;

import org.shiftworks.domain.ChatRoomVO;
import org.shiftworks.domain.ChatVO;


public interface ChatRoomMapper {
	
	int insertChatRoom(ChatRoomVO chatRoom);
	List<ChatRoomVO> getList(String emp_id);
	int deleteChatRoom(Integer room_id);
	int updateLastchat(ChatVO chat);
}
