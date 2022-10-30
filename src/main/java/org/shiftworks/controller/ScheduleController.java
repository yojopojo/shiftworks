package org.shiftworks.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.shiftworks.domain.ScheduleCriteria;
import org.shiftworks.domain.ScheduleVO;
import org.shiftworks.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("/schedule/*")
@AllArgsConstructor
public class ScheduleController {

	private ScheduleService service;
	
	@GetMapping("/main")
	public ModelAndView schedule() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/schedule/SCH_list");
		return mav;
	}
	
	// 그룹별, 월별 일정 가져오기
	@GetMapping(value="/{sch_group}/{selectedDate}",
				produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<ScheduleVO>> getList(
			@PathVariable String sch_group, @PathVariable String selectedDate) {
		
		if(sch_group.equals("all")) {
			sch_group = null;
		}
		
		log.info("선택일: " + selectedDate);
		log.info("선택그룹: " + sch_group);
		
		List<ScheduleVO> list = service.getList(new ScheduleCriteria(sch_group, selectedDate));
		
		return new ResponseEntity<List<ScheduleVO>>(list, HttpStatus.OK);
	}
	
	
	// 일정 검색
	@GetMapping(value="/search/{keyword}",
				produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<ScheduleVO>> search(@PathVariable String keyword) {
		
		List<ScheduleVO> list = service.search(keyword);
		
		return new ResponseEntity<List<ScheduleVO>>(list, HttpStatus.OK);
	}
	
	// 일정 상세 보기
	@GetMapping(value="/{sch_id}",
				produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ScheduleVO> getSchedule(@PathVariable Integer sch_id) {
		
		ScheduleVO vo = service.getSchedule(sch_id);
		
		return new ResponseEntity<ScheduleVO>(vo, HttpStatus.OK);
	}
	
	// 일정 등록
	@PostMapping(value="/new",
					produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> insertSchedule(@RequestBody ScheduleVO scheduleVO) {
		
		return service.insertSchedule(scheduleVO) ?
			new ResponseEntity<String>("success", HttpStatus.OK) :
			new ResponseEntity<String>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	// 일정 수정
	@RequestMapping(method = {RequestMethod.PATCH, RequestMethod.PUT},
					value="/{sch_id}",
					produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> updateSchedule(@RequestBody ScheduleVO scheduleVO) {
		
		return service.updateSchedule(scheduleVO) ?
			new ResponseEntity<String>("success", HttpStatus.OK) :
			new ResponseEntity<String>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 일정 삭제
	@DeleteMapping(value="/{sch_id}",
					produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> deleteSchedule(@PathVariable Integer sch_id, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String emp_id = (String) session.getAttribute("emp_id");
		
		return service.deleteSchedule(sch_id, emp_id) ?
				new ResponseEntity<String>("success", HttpStatus.OK) :
				new ResponseEntity<String>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 메모 가져오기
	@GetMapping(value="/memo",
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> getMemo(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String emp_id = (String) session.getAttribute("emp_id");
		
		return new ResponseEntity<String>(service.getMemo(emp_id), HttpStatus.OK);
	}
	
	// 메모 업데이트
	@RequestMapping(method = {RequestMethod.PATCH, RequestMethod.PUT},
			value="/memo",
			produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> updateMemo(HttpServletRequest request, @RequestBody String memo) {
	
		HttpSession session = request.getSession();
		String emp_id = (String) session.getAttribute("emp_id");
		
		return service.updateMemo(emp_id, memo) ?
			new ResponseEntity<String>("success", HttpStatus.OK) :
			new ResponseEntity<String>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
