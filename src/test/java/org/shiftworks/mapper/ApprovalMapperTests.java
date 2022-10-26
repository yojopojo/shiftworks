package org.shiftworks.mapper;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.shiftworks.domain.ApprovalVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Data;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ApprovalMapperTests {
	

	@Autowired
	private ApprovalMapper mapper;
	
//	@Test
//	public void testGetList() {
//		mapper.getList().forEach(approval -> log.info(approval));
//	}
	
//	@Test
//	public void testInsert() {
//		ApprovalVO approval = new ApprovalVO();
//		approval.setApr_title("새로 작성하는 글");
//		approval.setApr_content("새로 작성하는 내용");
//		approval.setApr_status('1');
//		
//		mapper.insert(approval);
//		log.info(approval);
//
//	}
	
//	@Test
//	public void testRead() {
//		ApprovalVO approval = mapper.read(1);
//		log.info(approval);
//	}
	
	@Test
	public void testUpdate() {
		ApprovalVO approval = new ApprovalVO();
		approval.setApr_id(1);
		approval.setApr_status('3');
		approval.setApr_check(3);
		
		int count = mapper.update(approval);
		log.info("UPDATE COUNT: " + count);
	}
	

}
