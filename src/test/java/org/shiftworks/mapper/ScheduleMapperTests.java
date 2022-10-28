package org.shiftworks.mapper;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.shiftworks.domain.ScheduleCriteria;
import org.shiftworks.domain.ScheduleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ScheduleMapperTests {
	
	@Autowired
	private ScheduleMapper mapper;

	// 일정 입력 테스트
	@Test
	public void testInsertSchedule() {
		ScheduleVO vo = new ScheduleVO();
		
		String[] arr = {"S8945709", "U2946709"};
		
		vo.setBook_id(5);
		vo.setDept_id("neuro289");
		vo.setEmp_id("U2946709");
		vo.setSch_group("부서");
		vo.setStart_date("2022-10-07");
		vo.setEnd_date("2022-10-09");
		vo.setSch_title("view 테스트");
		vo.setSch_content("test.");
		vo.setParticipant(arr);
		
		mapper.insertSchedule(vo);
	}
	
	// 모든 참가자의 일정 리스트에 일정 등록
//	@Test
//	public void testInsertParticipant() {
//		ScheduleVO vo = new ScheduleVO();
//		
//		String[] arr = {"S8945709", "U2946709"};
//		vo.setDept_id("neuro289");
//		vo.setEmp_id("U2946709");
//		vo.setParticipant(arr);
//		vo.setSch_id(5);
//		
//		for(String p : vo.getParticipant()) {
//			vo.setEmp_id(p);
//			mapper.insertParticipant(vo);
//		}
//	}
	
	// 일정 수정
//	@Test
//	public void testUpdateSchedule() {
//		ScheduleVO vo = new ScheduleVO();
//		
//		vo.setSch_id(3);
//		vo.setSch_title("수정한 제목");
//		vo.setSch_content("수정한 텍스트");
//		vo.setStart_date("2022-11-02");
//		vo.setEnd_date("2022-11-05");
//		vo.setBook_id(9);
//		
//		mapper.updateSchedule(vo);
//	}
	
	// 일정 삭제
//	@Test
//	public void testDeleteSchedule() {
//		mapper.deleteSchedule(3);
//		mapper.deleteParticipant(3, null);
//	}
	
	// 일정 불러오기
//	@Test
//	public void testGetList() {
//		ScheduleCriteria cri = new ScheduleCriteria("2022-05-02", "부서");
//		
//		mapper.getList(cri);
//	}
	
	// 일정 검색하기
//	@Test
//	public void testSearch() {
//		mapper.search("수정");
//	}

	// 일정 상세보기
//	@Test
//	public void testGetSchedule() {
//		mapper.getSchedule(1);
//	}
	
	// 메모 불러오기, 수정
//	@Test
//	public void testMemo() {
//		mapper.updateMemo("S8945709", "안녕하세요?");
//		mapper.getMemo("S8945709");
//	}
	
	// 일정 참가자 리스트 불러오기
//	@Test
//	public void testGetParticipant() {
//		mapper.getParticipant(5);
//	}
	
}
