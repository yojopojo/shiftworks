package org.shiftworks.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.shiftworks.domain.TaskCriteria;
import org.shiftworks.domain.TaskPageDTO;
import org.shiftworks.domain.TaskVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TaskServiceTests {
	
	@Autowired
	private TaskService service;

	// 검색기능 적용 페이징 처리
//	@Test
//	public void testGetList() {
//		
//		TaskCriteria cri = new TaskCriteria(1, "T", "제목", "dept");
//		
//		service.getList(cri);
//	}
	
	// 업무 게시글 개별 출력
//	@Test
//	public void testGetTask() {
//		
//		service.getTask(5);
//	}
	
	// 업무 등록 단위테스트
//	@Test
//	public void testInsert() {
//		TaskVO task = new TaskVO();
//		
//		task.setDept_id("dept2");
//		task.setTask_title("단위테스트");
//		task.setTask_writer("test?");
//		task.setTask_content("Task 단위테스트입니다.");
//		task.setCategory("기타");
//
//		log.info(service.insertTask(task));;
//		
//	}
	
	// 업무 수정 단위 테스트
//	@Test
//	public void testUpdate() {
//		TaskVO task = new TaskVO();
//		
//		task.setTask_id(30);
//		task.setDept_id("dept9");
//		task.setTask_title("단위테스트 수정");
//		task.setTask_content("updateTask 단위테스트 수정입니다.");
//		task.setCategory("기타");
//		
//		log.info(service.updateTask(task));
//	}
	
	// 업무 삭제 단위 테스트
	@Test
	public void testDelete() {
		log.info(service.deleteTask(159));
	}

}
