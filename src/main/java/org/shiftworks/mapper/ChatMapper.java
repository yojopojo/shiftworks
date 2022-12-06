package org.shiftworks.mapper;

import java.util.List;

import org.shiftworks.domain.ChatDTO;
import org.shiftworks.domain.ChatVO;

public interface ChatMapper {
	Integer insertChat(ChatVO message);	// 메시지 저장
	List<ChatDTO> getList(String room_id);	// 모든 메시지 검색
}
