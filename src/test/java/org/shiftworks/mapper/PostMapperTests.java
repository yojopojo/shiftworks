package org.shiftworks.mapper;

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
public class PostMapperTests {
	
	@Autowired
	private PostMapper mapper;
	
	
//	 @Test 
//	 public void testInsert() { 
//		 PostVO postvo = new PostVO();
//	 
//	 	postvo.setB_id(1); 
//	 	postvo.setEmp_id("1000"); 
//	 	postvo.setDept_id("10");
//	 	postvo.setPost_name("첫 등록");
//	 	postvo.setPost_content("첫등록입니다");
//	 	postvo.setPost_receivedept("11");
//	  
//	  mapper.insertPost(postvo);
//	  
//	  log.info(postvo);
//	  }
	 
	
//	@Test
//	public void testGetList() {
//		 mapper.getListPostVO().forEach(post -> log.info(post));
//		
//	}
	
//	@Test
//	public void testUpdate() {
//		PostVO postvo = new PostVO();
//		
//		postvo.setPost_id(1);
//		postvo.setPost_name("수정");
//		postvo.setPost_content("수정되나요?");
//		postvo.setPost_receivedept("12");
//		
//		mapper.updatePost(postvo);
//	}
	
//	@Test
//	public void testDelete() {
//		int target = 1;
//		int count = mapper.deletePost(target);
//		log.info("count: " +count);
//	}
	
//	@Test
//	public void testGet() {
//		int target =2;
//		log.info(mapper.getPost(target));
//	}
	
	@Test
	public void testGetListPaging() {
		Criteria cri = new Criteria();
		cri.setKeyword("김기역");
		cri.setType("W");
		List<PostVO> list = mapper.getListWithPaging(cri);
		list.forEach(post -> log.info(post));
	}


}
