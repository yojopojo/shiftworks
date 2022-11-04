package org.shiftworks.mapper;

import java.util.List;

import org.shiftworks.domain.ChatRoomUserVO;

public interface ChatRoomUserMapper {
	List<ChatRoomUserVO> getList(int room_id);
	int insertChatRoomUser(ChatRoomUserVO chatRoomUser);
	int deleteChatRoomUser(String emp_id);
}
