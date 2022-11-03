package org.shiftworks.mapper;

import java.util.List;

import org.shiftworks.domain.ChatDTO;

public interface ChatMapper {
	int insertChat(ChatDTO message);	// 메시지 저장
	List<ChatDTO> getList(Integer room_id);	// 모든 메시지 검색
}
