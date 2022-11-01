package org.shiftworks.messenger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.shiftworks.domain.ChatVO;
import org.shiftworks.mapper.ChatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
//context 경로를 알아야 테스트 가능
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ChatTests {

	@Autowired
	ChatMapper mapper;
	
	// 채팅 저장하기
	@Test
	public void testGetList() {
				
		mapper.getList().forEach(chat->log.info(chat));
	}
	
//	// 채팅방에서 전송된 채팅 가져오기
//	@Test
//	public void testInsert() {
//		
//		ChatVO chat = new ChatVO();
//		chat.setContent("test3");
//		chat.setSender("U2946709");
//		chat.setSendtime("2022-10-25 11:58:33");
//		chat.setRoom_id(1);
//		
//		int re = mapper.insertChat(chat);
//		log.info(chat);
//		log.info("re = " + re);
//	}
}
