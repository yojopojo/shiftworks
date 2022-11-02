package org.shiftworks.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.shiftworks.domain.Criteria;
import org.shiftworks.domain.PostVO;
import org.shiftworks.domain.ScrapVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DocumentServiceTests {
	
	@Autowired
	private DocumentService service;
	
//	@Test
//	public void testGetDocumentList() {
//		
//		Criteria cri = new Criteria();
//		cri.setType("W");
//		cri.setKeyword("3");
//		service.getMyDocumentListWithPaging(cri).getList().forEach(post -> log.info(post));
//	}
	
	
//	@Test
//	public void testGetDocument() {
//		PostVO vo = new PostVO();
//		
//		vo.setEmp_id("2");
//		vo.setPost_id(21);
//		
//		log.info(service.getMyDocument(vo));
//	}
	
	
	@Test
	public void testScrapList() {
		
		Criteria cri = new Criteria();
		String emp_id ="2";
		service.getScrapListWithPaging(cri).getList().forEach(scrap -> log.info(scrap));
	}
	
//	@Test
//	public void testScrap() {
//		ScrapVO vo = new ScrapVO();
//		vo.setEmp_id("12");
//		vo.setPost_id(8);
//		
//		log.info(service.getScrap(vo));
//	}
	
//	@Test
//	public void testDeptSelectList() {
//		
//		String post_receivededept = "12";
//		
//		service.deptSelectList(post_receivededept).forEach(post -> log.info(post));
//	}
	
//	@Test
//	public void testDeptSelect() {
//		
//		PostVO vo = new PostVO();
//		vo.setPost_id(21);
//		vo.setPost_receivedept("12");
//		
//		log.info(service.deptSelect(vo));
//	}
	

}
