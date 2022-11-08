package org.shiftworks.service;

import java.util.List;

import org.shiftworks.domain.ChatRoomDTO;
import org.shiftworks.domain.ChatRoomVO;
import org.shiftworks.mapper.ChatRoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatRoomServiceImpl implements ChatRoomService{
	
	@Autowired
	ChatRoomMapper chatRoomMapper;

	@Override
	public List<ChatRoomVO> getList(String emp_id) {
		
		return chatRoomMapper.getList(emp_id);
	}
	
	
	
	@Override
	public Integer insertChatRoom(ChatRoomDTO chatRoom) {
	
		return chatRoomMapper.insertChatRoom(chatRoom);
	}
	
	
}
