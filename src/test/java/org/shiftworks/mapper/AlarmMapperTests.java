package org.shiftworks.mapper;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.shiftworks.domain.AlarmVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class AlarmMapperTests {
	
	@Autowired
	private AlarmMapper mapper;

	// 알림 생성
//	@Test
//	public void testInsert() {
//		
//		AlarmVO vo = new AlarmVO();
//		
//		vo.setDept_id("dept");
//		vo.setContent("알림 테스트");
//		vo.setEmp_id("1");
//		
//		log.info(mapper.insertAlarm(vo));
//		vo.setDept_id("dept");
//		vo.setContent("알림 테스트");
//		vo.setEmp_id("2");
//		
//		log.info(mapper.insertAlarm(vo));
//		vo.setDept_id("dept");
//		vo.setContent("알림 테스트");
//		vo.setEmp_id("3");
//		
//		log.info(mapper.insertAlarm(vo));
//		
//	}
	
	// 알림 개별 삭제
//	@Test
//	public void testDelete() {
//		log.info(mapper.deleteAlarm(1));
//	}

	// 알림 가져오기
//	@Test
//	public void testGet() {
//		mapper.getAlarm("1");
//	}
	
}
