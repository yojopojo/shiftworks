package org.shiftworks.mapper;

import java.util.List;

import org.shiftworks.domain.ReceiverVO;

public interface ReceiverMapper {
	List<ReceiverVO> getReceiverList();
	int insertReceiver(ReceiverVO receiver);	// 수신자 저장
	int updateChecking(ReceiverVO receiver);	// 읽음으로 변경
}
