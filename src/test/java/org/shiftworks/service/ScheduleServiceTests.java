package org.shiftworks.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.shiftworks.domain.ScheduleCriteria;
import org.shiftworks.domain.ScheduleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ScheduleServiceTests {

	@Autowired
	private ScheduleService service;
	
	// 일정 출력
//	@Test
//	public void testGetList() {
//		ScheduleCriteria cri = new ScheduleCriteria("2022-09-02", "부서");
//		service.getList(cri);
//	}
	
	// 일정 개별 보기
//	@Test
//	public void testGetSchedule() {
//		service.getSchedule(1);
//	}
	
	// 메모 입력, 불러오기
//	@Test
//	public void testMemo() {
//		service.updateMemo("U2946709", "서비스테스트");
//		service.getMemo("U2946709");
//	}
	
	// 일정 등록
	@Test
	public void testInsertSchedule() {
		ScheduleVO vo = new ScheduleVO();
		
		String[] arr = {"U2946709", "S8891577"};
		
		vo.setBook_id(12);
		vo.setDept_id("infosecu8");
		vo.setEmp_id("U2946709");
		vo.setSch_group("부서");
		vo.setStart_date("2022-09-20");
		vo.setEnd_date("2022-09-27");
		vo.setSch_title("시퀀스 마지막 테스트");
		vo.setSch_content("test.");
		vo.setParticipant(arr);
		
		log.info(service.insertSchedule(vo));;
	}
	
	// 일정 수정
//	@Test
//	public void testUpdateSchedule() {
//		ScheduleVO vo = new ScheduleVO();
//		
//		vo.setSch_id(13);
//		vo.setBook_id(55);
//		vo.setSch_title("업데이트 테스트");
//		vo.setSch_content("수정 테스트입니다.");
//		vo.setStart_date("2022-01-20");
//		vo.setEnd_date("2022-01-27");
//		
//		service.updateSchedule(vo);
//	}
	
	// 일정 삭제
//	@Test
//	public void testDeleteSchedule() {
//		service.deleteSchedule(5, "U2946709");
//		service.deleteSchedule(5, "S8945709");
//	}

}
