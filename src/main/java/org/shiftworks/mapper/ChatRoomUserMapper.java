package org.shiftworks.mapper;

import java.util.List;

import org.shiftworks.domain.ChatRoomUserVO;

public interface ChatRoomUserMapper {
	List<ChatRoomUserVO> getReceiverList();
	int insertReceiver(ChatRoomUserVO receiver);	// 수신자 저장
	int updateChecking(ChatRoomUserVO receiver);	// 읽음으로 변경
}
