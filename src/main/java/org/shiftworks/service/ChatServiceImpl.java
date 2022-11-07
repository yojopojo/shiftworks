package org.shiftworks.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.shiftworks.domain.ChatRoomVO;
import org.shiftworks.domain.ChatVO;
import org.shiftworks.domain.ChatDTO;
import org.shiftworks.mapper.ChatMapper;
import org.shiftworks.mapper.ChatRoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ChatServiceImpl implements ChatService {

	@Autowired
	private ChatRoomMapper chatRoomMapper;

	@Autowired
	private ChatMapper chatMapper;

	@Override
	public List<ChatRoomVO> getChatRoomList(String emp_id) {

		log.info("#ChatServiceImpl, getChatRommList.................");
		return chatRoomMapper.getList(emp_id);
	}

	@Override
	public List<ChatDTO> getChatList(Integer room_id) {

		log.info("#ChatServiceImpl, getChatList....................");

		return chatMapper.getList(room_id);
	}

	@Override
	public Integer sendChat(ChatVO chat) {
		log.info("#ChatServiceImpl, sendChat....................");
		
		return chatMapper.insertChat(chat);
	}
	
	@Override
	public Integer updateLastChat(ChatVO chat) {
		log.info("#ChatServiceImpl, updateLastChat....................");
		
		return chatRoomMapper.updateLastchat(chat);
	}

}
