package org.shiftworks.mapper;

import java.util.List;

import org.shiftworks.domain.ChatVO;

public interface MessageMapper {
	int insertMessage(ChatVO message);	// 메시지 저장
	List<ChatVO> getList();	// 모든 메시지 검색
	ChatVO getMessage(int msg_id);	// 상세 메시지 검색
	List<ChatVO> getNoticeSendMessage(String sender);	// 공지로 보낸 메시지 검색
	List<ChatVO> getImportantSendMessage(String sender);	// 중요로 보낸 메시지 검색
	List<ChatVO> getNoticeReceiveMessage(String sender);	// 공지로 받은 메시지 검색
	List<ChatVO> getImportantReceiveMessage(String sender);	// 중요로 받은 메시지 검색
	List<ChatVO> getSendMessage(String sender);	// 보낸 메시지 검색
	List<ChatVO> getReceiveMessage(String sender);	// 받은 메시지 검색
}
