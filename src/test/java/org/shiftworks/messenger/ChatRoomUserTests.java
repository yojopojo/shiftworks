package org.shiftworks.messenger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.shiftworks.domain.ChatRoomUserVO;
import org.shiftworks.mapper.ChatRoomUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
//context 경로를 알아야 테스트 가능
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ChatRoomUserTests {
	
	@Autowired
	ChatRoomUserMapper mapper;
	
	@Test
	public void testGetReceiverList() {
		mapper.getList(1).forEach(chatRoomUser->log.info(chatRoomUser));
	}
	
//	@Test
//	public void testInsert() {
//		ChatRoomUserVO chatRoomUser = new ChatRoomUserVO();
//		chatRoomUser.setRoom_id(1);
//		chatRoomUser.setEmp_id("U3948709");
//		chatRoomUser.setDept_id("msdept09");
//		
//		log.info("testInsert : " + mapper.insertChatRoomUser(chatRoomUser));
//	}
	
//	@Test
//	public void testDelete() {
//		log.info("testDelete : " + mapper.deleteChatRoomUser("U3948709"));
//	}
}
