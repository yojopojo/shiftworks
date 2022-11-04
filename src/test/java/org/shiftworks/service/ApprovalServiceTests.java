package org.shiftworks.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.shiftworks.domain.ApprovalVO;
import org.shiftworks.domain.ApprovalCriteria;
import org.shiftworks.domain.TempApprovalVO;
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
	
//	@Test
//	public void testExists() {
//		log.info(service);
//		assertNotNull(service);
//	}
//	
//	@Test
//	public void testInsertTest() {
//		ApprovalVO vo = new ApprovalVO();
//		vo.setAf_id(4);
//		vo.setEmp_id("def");
//		vo.setApr_title("def");
//		vo.setApr_content("def");
//		vo.setApr_status('4');
//		vo.setApr_comment("작동 여부 확인4");
//		
//		int a = service.insertForm(vo);
//		log.info("a:"+ a);
//	}
//	
//	@Test
//	public void testGetList() {
//		//service.getList().forEach(approval->log.info(approval));
//		service.getList(new Criteria(2,10)).forEach(approval->log.info(approval));
//	}
//	
//	@Test
//	public void testGet() {
//		log.info(service.get(1));
//	}
//	
//	@Test
//	public void testUpdate() {
//		ApprovalVO approval = service.get(44);
//		if (approval == null) {
//			return;
//		}
//		approval.setApr_title("결재 제목 수정 확인");
//		approval.setApr_comment("코멘트 수정 여부 확인");
//		log.info("UPDATE RESULT: " + service.update(approval));
//	}
	
	
//	@Test
//	public void testGetListWithReceived() {
//		//service.getList().forEach(approval->log.info(approval));
//		service.getReceivedList(new Criteria(1, 500)).forEach(approval -> log.info(approval));
//	}
	
	@Test
	public void testInsertTemporal() {
		TempApprovalVO vo = new TempApprovalVO();
		vo.setAf_id(0);
		vo.setDept_id("dept2");
		vo.setEmp_id("emp2");
		vo.setTemp_title("임시저장");
		vo.setTemp_content("임시저장 서비스 테스트");
		
		
	}
}
