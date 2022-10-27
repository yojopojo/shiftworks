package org.shiftworks.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.shiftworks.domain.Criteria;
import org.shiftworks.domain.PostVO;
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

	@Test
	public void testGetList() {
		Criteria cri = new Criteria(1, 180);
		cri.setType("T");
		cri.setKeyword("jsp");
		service.getListSearch(cri).forEach(post -> log.info(post));
	}
	
//	@Test
//	public void testInsert() {
//		PostVO vo = new PostVO();
//		
//		vo.setB_id(2);
//		vo.setDept_id("11");
//		vo.setEmp_id("1002");
//		vo.setPost_name("서비스입니다");
//		vo.setPost_content("서비스 내용입니다");
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
	

}
