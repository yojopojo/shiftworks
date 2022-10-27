package org.shiftworks.messenger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.shiftworks.domain.ReceiverVO;
import org.shiftworks.mapper.ReceiverMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
//context 경로를 알아야 테스트 가능
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReceiverTests {
	
	@Autowired
	ReceiverMapper mapper;
	
	@Test
	public void testGetReceiverList() {
		mapper.getReceiverList().forEach(receiver->log.info(receiver));
	}
	
//	@Test
//	public void testUpdate() {
//		log.info(mapper.updateChecking(new ReceiverVO(1, "S8891577", "infosecu8")));
//	}

//	@Test
//	public void testInsert() {
//		
//		ReceiverVO receiver = new ReceiverVO(5, "S8891577", "infosecu8");
//		log.info(mapper.insertReceiver(receiver));
//	}
}
