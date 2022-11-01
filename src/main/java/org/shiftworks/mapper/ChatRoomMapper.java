package org.shiftworks.mapper;

import java.util.List;

import org.shiftworks.domain.ChatRoomVO;


public interface ChatRoomMapper {
	
	int insertChatRoom(ChatRoomVO chatRoom);
	List<ChatRoomVO> getList(int room_id);
	int deleteChatRoom(int room_id);
}
