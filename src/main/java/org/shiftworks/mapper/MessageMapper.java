package org.shiftworks.mapper;

import java.util.List;

import org.shiftworks.domain.MessageVO;

public interface MessageMapper {
	int insertMessage(MessageVO message);	// 메시지 저장
	List<MessageVO> getList();	// 모든 메시지 검색
	MessageVO getMessage(int msg_id);	// 상세 메시지 검색
	List<MessageVO> getNoticeSendMessage(String sender);	// 공지로 보낸 메시지 검색
	List<MessageVO> getImportantSendMessage(String sender);	// 중요로 보낸 메시지 검색
	List<MessageVO> getNoticeReceiveMessage(String sender);	// 공지로 받은 메시지 검색
	List<MessageVO> getImportantReceiveMessage(String sender);	// 중요로 받은 메시지 검색
	List<MessageVO> getSendMessage(String sender);	// 보낸 메시지 검색
	List<MessageVO> getReceiveMessage(String sender);	// 받은 메시지 검색
}
