package org.shiftworks.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.shiftworks.domain.AlarmVO;
import org.shiftworks.domain.ScheduleCriteria;
import org.shiftworks.domain.ScheduleVO;
import org.shiftworks.domain.WorkScheduleVO;
import org.shiftworks.mapper.AlarmMapper;
import org.shiftworks.mapper.ScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ScheduleServiceImpl implements ScheduleService {
	
	@Autowired
	private ScheduleMapper mapper;
	
	@Autowired
	private AlarmMapper alarmMapper;

	// 월별 일정 가져오기
	@Override
	public List<ScheduleVO> getList(ScheduleCriteria cri) {
		return mapper.getList(cri);
	}
	
	@Override
	public List<ScheduleVO> search(String keyword, String emp_id) {
	
		return mapper.search(keyword, emp_id);
	}

	// 개별 일정 가져오기
	@Override
	public ScheduleVO getSchedule(Integer sch_id) {
		return mapper.getSchedule(sch_id);
	}

	// 일정, 참가자 리스트 등록
	@Transactional
	@Override
	public boolean insertSchedule(ScheduleVO scheduleVO) {
		// 일정 생성
		boolean result1 = mapper.insertSchedule(scheduleVO) == 1;
		boolean result2 = false;
		int count = 0;
		
		// 일정 참가자가 두 명 이상일 경우 해당 인원 모두가 일정을 확인할 수 있게 함
		for(String p : scheduleVO.getParticipant()) {
			scheduleVO.setEmp_id(p);
			// 일정 캘린더에 표시될 수 있도록 함
			mapper.insertParticipant(scheduleVO);
			
			// 일정에 대한 알림 생성(세션 받아온 뒤 수정)
			AlarmVO vo = new AlarmVO();
			String str = "[" + scheduleVO.getSch_title() + "] 일정이 등록되었습니다.";
			
			// 알림을 생성하기 위한 정보 입력
			vo.setEmp_id(scheduleVO.getEmp_id());
			vo.setDept_id(scheduleVO.getDept_id());
			vo.setContent(str);
			
			// D-day에 알림이 가도록 start_date를 알림 날짜로 설정
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			
			try {
				vo.setDate_created(df.parse(scheduleVO.getStart_date()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			alarmMapper.insertDday(vo);
			
			count++;
		}
		
		result2 = count > 0;
		
		log.info("result1: " + result1);
		log.info("result2: " + result2);
		
		return result1 && result2 ;
	}

	// 일정 수정
	@Override
	public boolean updateSchedule(ScheduleVO scheduleVO) {
		return mapper.updateSchedule(scheduleVO) == 1;
	}

	// 일정 삭제
	@Transactional
	@Override
	public boolean deleteSchedule(Integer sch_id, String emp_id) {
		
		// 모든 사람에게서 일정이 삭제되면 해당 일정 자체를 삭제
		boolean result = mapper.deleteParticipant(sch_id, emp_id) > 0;
		
		if (mapper.getParticipant(sch_id).size() == 0) {
			result = mapper.deleteSchedule(sch_id) == 1;
		}
		
		return result;

	}

	// 메모 가져오기
	@Override
	public String getMemo(String emp_id) {
		return mapper.getMemo(emp_id);
	}

	// 메모 수정(등록)
	@Override
	public boolean updateMemo(String emp_id, String memo) {
		return mapper.updateMemo(emp_id, memo) == 1;
	}

	// 같은 부서 직원의 근무 스케쥴 불러오기
	@Override
	public List<WorkScheduleVO> getWorkerList(String dept_id) {
		return mapper.getWorkerList(dept_id);
	}

}
