package org.shiftworks.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.shiftworks.domain.BoardCriteria;
import org.shiftworks.domain.BoardVO;
import org.shiftworks.domain.EmployeeVO;
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
//	 	postvo.setEmp_id("U2946709"); 
//	 	postvo.setDept_id("1");
//	 	postvo.setPost_name("조희영");
//	 	postvo.setPost_content("와");
//	 	postvo.setPost_receivedept("3");
//	  
//	  mapper.insertPost(postvo);
//	  log.info(postvo);
//	  
//	  }
	 
	
//	@Test
//	public void testGetList() {
//		Criteria cri = new Criteria();
//		
//		 mapper.getListNoticeWithPagingSearch(cri).forEach(post -> log.info(post));
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
//		
//		vo.setPost_regdate("2022-10-20");
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
	
//	@Test
//	public void testGetDeptId() {
//		String emp_id ="user1";
//		log.info(mapper.getDeptId(emp_id));;
//		
//	}
	
//	@Test
//	public void testselectPrev() {
//		int post_id = 25;
//		log.info(mapper.selectPrev(post_id));
//	}

//	@Test
//	public void testInsertNewBoard() {
//		BoardVO vo  = new BoardVO();
//		vo.setB_name("자료실");
//		vo.setB_content("여러 자료실 관련");
//		vo.setB_private("N");
//		
//		mapper.insertNewBoard(vo);
//	}
	
	
//	@Test
//	public void testSelectBoardList() {
//		mapper.selectBoardList().forEach(board ->log.info(board));
//	}
	
}
