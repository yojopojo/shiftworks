package org.shiftworks.mapper;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.shiftworks.domain.DocumentCriteria;
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
//	public void testgetListMyDocWithPagingSearch() {
//		
//		Criteria cri = new Criteria();
//		cri.setPageNum(1);
//		cri.setAmount(10);
//	
//		mapper.getListMyDocWithPagingSearch(cri).forEach(post -> log.info(post));
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
//	
//	@Test
//	public void testGetScrap() {
//		
//		ScrapVO vo = new ScrapVO();
//		vo.setPost_id(8);
//		vo.setEmp_id("12");
//		
//		log.info(mapper.getScrap(vo));
//		
//	}
	
	@Test
	public void testDeptSelectList() {
		String dept_id = "dept1";
		String emp_id = "ul";
	
		DocumentCriteria cri = new DocumentCriteria();
		cri.setDept_id(dept_id);
		cri.setEmp_id(emp_id);
		cri.setAmount(10);
		cri.setPageNum(1);
	
		
		mapper.deptSelectList(cri).forEach(post -> log.info(post));
	}
	
//	@Test
//	public void testDeptSelect() {
//		PostVO vo = new PostVO();
//		vo.setPost_id(21);
//		vo.setPost_receivedept("12");
//		
//		log.info(mapper.deptSelect(vo));
//	}
	
//	@Test
//	public void getTotal() {
//		String emp_id ="U3948709";
//		log.info(mapper.getTotalMyDoc(emp_id));
//	}

}
