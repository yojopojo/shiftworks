package org.shiftworks.mapper;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.shiftworks.domain.PostVO;
import org.shiftworks.domain.ScrapVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DocumnetMapperTests {
	
	@Autowired
	private DocumentMapper mapper;

//	@Test
//	public void testGetMyDocumentList() {
//		
//		String emp_id = "2";
//	
//		mapper.getMyDocumentList(emp_id).forEach(post -> log.info(post));
//	}
	
//	@Test
//	public void testGetMyDocument() {
//		PostVO vo = new PostVO();
//		vo.setEmp_id("2");
//		vo.setPost_id(21);
//		
//		log.info(mapper.getMyDocument(vo));
//	}
	
//	@Test
//	public void testGetScrapList() {
//		
//		String emp_id="2";
//		
//		mapper.getScrapList(emp_id).forEach(scrap -> log.info(scrap));
//	}
	
	@Test
	public void testGetScrap() {
		
		ScrapVO vo = new ScrapVO();
		vo.setPost_id(8);
		vo.setEmp_id("12");
		
		log.info(mapper.getScrap(vo));
		
	}

}
