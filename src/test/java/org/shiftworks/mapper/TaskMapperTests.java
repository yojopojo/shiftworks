package org.shiftworks.mapper;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.shiftworks.domain.TaskCriteria;
import org.shiftworks.domain.TaskPageDTO;
import org.shiftworks.domain.TaskVO;
import org.shiftworks.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;
import oracle.net.aso.l;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TaskMapperTests {
	
	@Autowired
	private TaskMapper mapper;

	// insertTask 단위 테스트
//	@Test
//	public void testInsert() {
//		TaskVO task = new TaskVO();
//		
//		task.setDept_id("dept");
//		task.setTask_title("단위테스트");
//		task.setEmp_id("U2946709");
//		task.setTask_content("Task 단위테스트입니다.");
//		task.setCategory("기타");
//
//		mapper.insertTask(task);
//		
//		log.info(task);
//		
//	}
	
	// updateTask 단위 테스트
//	@Test
//	public void testUpdate() {
//		TaskVO task = new TaskVO();
//		
//		task.setTask_id(2);
//		task.setDept_id("dept9");
//		task.setTask_title("단위테스트 수정");
//		task.setTask_content("updateTask 단위테스트 수정입니다.");
//		task.setCategory("기타");
//		
//		mapper.updateTask(task);
//	}
	
	// deleteTask 단위 테스트
//	@Test
//	public void testDelete() {
//
//		mapper.deleteTask(2);
//		
//	}
	
	// 검색 조건에 일치하는 업무(게시글) 총 개수
//	@Test
//	public void testPaging() {
//		
//		TaskCriteria cri = new TaskCriteria(1);
//		cri.setKeyword("insert");
//		cri.setType("TCW");
//		
//		log.info(mapper.getTotalTask(cri));
//		
//		
//	}
	
	// 검색 조건을 적용한 페이징 처리
	@Test
	public void testGetListWithPaging() {
		TaskCriteria cri = new TaskCriteria(1, null, null, null, null);
		
		mapper.getListWithPaging(cri);
		
	}
	
	// 업무 개별 조회
//	@Test
//	public void testGetTask() {
//		mapper.getTask(9);
//	}

}
