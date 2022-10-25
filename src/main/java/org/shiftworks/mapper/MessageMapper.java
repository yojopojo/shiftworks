package org.shiftworks.mapper;

import java.util.List;

import org.shiftworks.domain.MessageVO;

public interface MessageMapper {
	int insertMessage(MessageVO message);
	List<MessageVO> getList();
	MessageVO getMessage(int msg_id);
	List<MessageVO> getNoticeMessage(String sender);
	List<MessageVO> getImportantMessage(String sender);
}
