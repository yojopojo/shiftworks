package org.shiftworks.messenger;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.shiftworks.domain.MessageVO;
import org.shiftworks.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
//context 경로를 알아야 테스트 가능
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MessageTests {

	@Autowired
	MessageMapper mapper;
	
	@Test
	public void getImportantMessage() {
		mapper.getImportantMessage("U2946709").forEach(message->log.info(message));
	}
	
//	@Test
//	public void getNoticeMessage() {
//		mapper.getNoticeMessage("U2946709").forEach(message->log.info(message));
//	}
	
//	@Test
//	public void getMessage() {
//		log.info(mapper.getMessage(1));
//	}
	
	
//	@Test
//	public void testGetList() {
//				
//		mapper.getList().forEach(message->log.info(message));
//	}
//	
	
//	@Test
//	public void testInsert() {
//		
//		MessageVO message = new MessageVO();
//		message.setNotice('Y');
//		message.setImportant('N');
//		message.setContent("notice message");
//		message.setSender("U2946709");
//		message.setTime("2022-10-25");
//		
//		int re = mapper.insertMessage(message);
//		log.info(message);
//		log.info("re = " + re);
//	}
	
}
