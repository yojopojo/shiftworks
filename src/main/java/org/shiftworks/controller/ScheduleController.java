package org.shiftworks.controller;

import java.util.List;

import org.shiftworks.domain.AccountCriteria;
import org.shiftworks.domain.BookingVO;
import org.shiftworks.domain.EmployeeVO;
import org.shiftworks.domain.ScheduleCriteria;
import org.shiftworks.domain.ScheduleVO;
import org.shiftworks.domain.WorkScheduleVO;
import org.shiftworks.mapper.EmployeeMapper;
import org.shiftworks.mapper.ScheduleMapper;
import org.shiftworks.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
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

	@Autowired
	private ScheduleService service;
	
	@Autowired
	private ScheduleMapper mapper;
	
	@Autowired
	private EmployeeMapper empMapper;
	
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
			@PathVariable String sch_group, @PathVariable String selectedDate, Authentication auth) {
		
		// 스케줄 그룹별 보기 미선택 시 null 적용하여 전체 일정 조회
		if(sch_group.equals("all")) {
			sch_group = null;
		}
		
		log.info("선택일: " + selectedDate);
		log.info("선택그룹: " + sch_group);
		
		// 로그인한 사람의 일정만 볼 수 있도록 토큰에서 로그인 사용자 정보 추출
		UserDetails ud = (UserDetails) auth.getPrincipal();
		log.info(ud.getUsername());
		
		List<ScheduleVO> list = service.getList(new ScheduleCriteria(ud.getUsername(), sch_group, selectedDate));
		
		return new ResponseEntity<List<ScheduleVO>>(list, HttpStatus.OK);
	}
	
	
	// 일정 검색
	@GetMapping(value="/search/{keyword}",
				produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<ScheduleVO>> search(@PathVariable String keyword, Authentication auth) {
		UserDetails ud = (UserDetails) auth.getPrincipal();
		
		List<ScheduleVO> list = service.search(keyword, ud.getUsername());
		
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
		
		if(scheduleVO.getBook_id() == null) {
			// 회의실 예약 번호가 미입력 되었을 경우 0으로 초기화
			scheduleVO.setBook_id(0);
		}
		
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
	public ResponseEntity<String> deleteSchedule(@PathVariable Integer sch_id, Authentication auth) {
		
		UserDetails ud = (UserDetails) auth.getPrincipal();
		
		return service.deleteSchedule(sch_id, ud.getUsername()) ?
				new ResponseEntity<String>("success", HttpStatus.OK) :
				new ResponseEntity<String>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 메모 가져오기
	@GetMapping(value="/memo",
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> getMemo(Authentication auth) {
		
		UserDetails ud = (UserDetails) auth.getPrincipal();
		
		return new ResponseEntity<String>(service.getMemo(ud.getUsername()), HttpStatus.OK);
	}
	
	// 메모 업데이트
	@RequestMapping(method = {RequestMethod.PATCH, RequestMethod.PUT},
			value="/memo",
			produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> updateMemo(@RequestBody String memo, Authentication auth) {
	
		UserDetails ud = (UserDetails) auth.getPrincipal();
		
		return service.updateMemo(ud.getUsername(), memo) ?
			new ResponseEntity<String>("success", HttpStatus.OK) :
			new ResponseEntity<String>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 참가자 등록 시 직원 검색하기
	@GetMapping(value="/participant/{name}",
				produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<EmployeeVO>> getEmployee(@PathVariable String name){
		// 계정 검색을 위한 criteria 계정 생성
		AccountCriteria cri = new AccountCriteria();
		// 검색어(이름) 입력
		cri.setKeyword(name);
		// 검색옵션(이름으로 검색) 입력
		cri.setType("N");
		List<EmployeeVO> list = empMapper.getListWithPaging(cri);
		return new ResponseEntity<List<EmployeeVO>>(list, HttpStatus.OK);
	}
	
	// 같은 부서 직원 스케쥴 불러오기
	@GetMapping(value="/worker/{dept_id}",
				produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<WorkScheduleVO>> getWorkerList(@PathVariable String dept_id) {
		
		List<WorkScheduleVO> list = service.getWorkerList(dept_id);
		
		return new ResponseEntity<List<WorkScheduleVO>>(list, HttpStatus.OK);
	}
	
	// 회의실 예약 목록 불러오기
	@GetMapping(value="/search/booking/{keyword}",
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<BookingVO>> searchBooking(@PathVariable String keyword) {
		
		List<BookingVO> list = mapper.searchBooking(keyword);
		
		return new ResponseEntity<List<BookingVO>>(list, HttpStatus.OK);
	}
	
	
}
