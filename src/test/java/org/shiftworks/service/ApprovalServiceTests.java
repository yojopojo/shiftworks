package org.shiftworks.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.shiftworks.domain.ApprovalVO;
import org.shiftworks.mapper.ApprovalMapperTests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ApprovalServiceTests {

	@Autowired
	private ApprovalService service;
	
	@Test
	public void testExists() {
		log.info(service);
		assertNotNull(service);
	}
	
	@Test
	public void testInsertTest() {
		ApprovalVO vo = new ApprovalVO();
		vo.setAf_id(1);
		vo.setEmp_id("abc");
		vo.setApr_title("abc");
		vo.setApr_content("abc");
		vo.setApr_check(1);
		vo.setApr_status('1');
		
		int a = service.insertForm(vo);
		log.info("a:"+ a);
	}
	
	@Test
	public void testGetList() {
		service.getList().forEach(approval->log.info(approval));
	}
	
	@Test
	public void testGet() {
		log.info(service.get(1));
	}
	
	@Test
	public void testUpdate() {
		ApprovalVO approval = service.get(2);
		if (approval == null) {
			return;
		}
		approval.setApr_title("결재 제목 수정");
		log.info("UPDATE RESULT: " + service.update(approval));
	}
	

}
