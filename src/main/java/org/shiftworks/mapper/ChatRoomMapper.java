package org.shiftworks.mapper;

import java.util.List;

import org.shiftworks.domain.ChatRoomDTO;
import org.shiftworks.domain.ChatRoomVO;
import org.shiftworks.domain.ChatVO;


public interface ChatRoomMapper {
	
	int insertChatRoom(ChatRoomDTO chatRoom);
	List<ChatRoomVO> getList(String emp_id);
	int deleteChatRoom(String room_id);
	int updateLastchat(ChatVO chat);
}
