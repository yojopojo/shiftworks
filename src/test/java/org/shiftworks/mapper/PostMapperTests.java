package org.shiftworks.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.shiftworks.domain.Criteria;
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
public class PostMapperTests {
	
	@Autowired
	private PostMapper mapper;
	

//	 @Test 
//	 public void testInsert() { 
//		 PostVO postvo = new PostVO();
//	 
//	 	postvo.setB_id(1); 
//	 	postvo.setEmp_id("23"); 
//	 	postvo.setDept_id("13");
//	 	postvo.setPost_name("둘 등록");
//	 	postvo.setPost_content("둘등록입니다");
//	 	postvo.setPost_receivedept("17");
//	  
//	  mapper.insertPost(postvo);
//	  log.info(postvo);
//	  
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
	
//	@Test
//	public void testGetListPaging() {
//		Criteria cri = new Criteria();
//		cri.setKeyword("김기역");
//		cri.setType("W");
//		List<PostVO> list = mapper.getListWithPaging(cri);
//		list.forEach(post -> log.info(post));
//	}
	
//	@Test
//	public void testInsertScrap() throws ParseException {
//		ScrapVO vo = new ScrapVO();
//		vo.setEmp_id("11");
//		vo.setPost_id(8);
//		vo.setDept_id("12");
//		vo.setPost_name("홍길동입니다");
//		vo.setPost_content("scrap test중입니다");
//
//
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		Date tempdate = df.parse("2022-10-28");
//		vo.setPost_regdate(tempdate);
//		
//		mapper.scrapPost(vo);
//		
//	}
	
//	@Test
//	public void testInsertTemporal() {
//		Temp_BoardVO vo = new Temp_BoardVO();
//		vo.setB_id(5);
//		vo.setDept_id("12");
//		vo.setEmp_id("17");
//		vo.setPost_name("임시");
//		vo.setPost_content("임시저장 테스트중");
//		
//		mapper.temporalPost(vo);
//	}
	
	
//	@Test
//	public void testTemporalSelect() {
//		
//		Temp_BoardVO vo = new Temp_BoardVO();
//		vo.setB_id(2);
//		vo.setEmp_id("17");
//		
//		log.info(mapper.temporalSelect(vo));
//		
//	}
	

	
	
}
