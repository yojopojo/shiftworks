package org.shiftworks.service;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.shiftworks.domain.BoardCriteria;
import org.shiftworks.domain.PostVO;
import org.shiftworks.domain.ScrapVO;
import org.shiftworks.domain.Temp_BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class PostServiceTests {
	
	@Autowired
	private PostService service;


//	@Test
//	public void testGetList() {
//		Criteria cri = new Criteria(1, 300);
//		cri.setType("W");
//		cri.setKeyword("성은지");
//		service.getListSearch(cri).forEach(post -> log.info(post));
//	}
	
//	@Test
//	public void testInsert() {
//		PostVO vo = new PostVO();
//		
//		vo.setB_id(2);
//		vo.setDept_id("11");
//		vo.setEmp_id("U2946709");
//		vo.setPost_name("호");
//		vo.setPost_content("성은지 내용입니다");
//		vo.setPost_receivedept("12");
//		
//		service.insertPost(vo);
//	}
	
//	@Test
//	public void testUpdate() {
//		PostVO vo = new PostVO();
//		vo.setPost_id(2);
//		vo.setPost_name("서비스 수정입니다");
//		vo.setPost_content("서비스 수정 내용입니다");
//		vo.setPost_receivedept("13");
//		
//		service.updatePost(vo);
//	
//	}
	
//	@Test
//	public void testDelete() {
//		int target = 2;
//		int count = service.deletePost(target);
//		log.info("count:" + count);
//	}
	
//	@Test
//	public void testGetPost() {
//		int target = 3;
//		log.info(service.getPost(target));
//	}
	
//	@Test
//	public void testInsertScrap() throws ParseException {
//		ScrapVO vo = new ScrapVO();
//		vo.setEmp_id("12");
//		vo.setPost_id(8);
//		vo.setDept_id("15");
//		vo.setPost_name("service test");
//		vo.setPost_content("scrap test중입니다");
//
//
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		Date tempdate = df.parse("2022-10-29");
//		vo.setPost_regdate(tempdate);
//		service.scrapPost(vo);
//	}
	
//	@Test
//	public void testInsertTemporal() {
//		Temp_BoardVO vo = new Temp_BoardVO();
//		vo.setB_id(3);
//		vo.setDept_id("12");
//		vo.setEmp_id("11");
//		vo.setPost_name("임시저장");
//		vo.setPost_content("임시저장 서비스 테스트중");
//	}
	
	
	

}
