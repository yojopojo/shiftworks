package org.shiftworks.mapper;

import java.util.List;

import org.shiftworks.domain.MessageVO;

public interface MessageMapper {
	int insertMessage(MessageVO message);	// 메시지 저장
	List<MessageVO> getList();	// 모든 메시지 검색
	MessageVO getMessage(int msg_id);	// 상세 메시지 검색
	List<MessageVO> getNoticeMessage(String sender);	// 공지 메시지 검색
	List<MessageVO> getImportantMessage(String sender);	// 중요 메시지 검색
	List<MessageVO> getSendMessage(String sender);	// 보낸 메시지 검색
	List<MessageVO> getReceiveMessage(String sender);	// 받은 메시지 검색
}
