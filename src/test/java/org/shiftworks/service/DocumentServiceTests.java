package org.shiftworks.service;

import org.junit.Test;
import org.junit.runner.RunWith;
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
//		String emp_id = "2";
//		service.getMyDocumentList(emp_id).forEach(post -> log.info(post));
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
	
	
//	@Test
//	public void testScrapList() {
//		
//		String emp_id ="2";
//		service.getScrapList(emp_id).forEach(scrap -> log.info(scrap));
//	}
	
	@Test
	public void testScrap() {
		ScrapVO vo = new ScrapVO();
		vo.setEmp_id("12");
		vo.setPost_id(8);
		
		log.info(service.getScrap(vo));
	}
	
	

}
