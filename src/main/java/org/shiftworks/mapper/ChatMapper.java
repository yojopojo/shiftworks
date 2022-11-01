package org.shiftworks.mapper;

import java.util.List;

import org.shiftworks.domain.ChatVO;

public interface ChatMapper {
	int insertChat(ChatVO message);	// 메시지 저장
	List<ChatVO> getList();	// 모든 메시지 검색
}
