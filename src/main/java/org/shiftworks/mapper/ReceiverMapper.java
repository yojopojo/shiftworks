package org.shiftworks.mapper;

import java.util.List;

import org.shiftworks.domain.ChatRoomVO;

public interface ReceiverMapper {
	List<ChatRoomVO> getReceiverList();
	int insertReceiver(ChatRoomVO receiver);	// 수신자 저장
	int updateChecking(ChatRoomVO receiver);	// 읽음으로 변경
}
