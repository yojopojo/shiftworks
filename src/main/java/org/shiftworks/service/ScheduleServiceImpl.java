package org.shiftworks.service;

import java.util.List;

import org.shiftworks.domain.ScheduleCriteria;
import org.shiftworks.domain.ScheduleVO;
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

	// 월별 일정 가져오기
	@Override
	public List<ScheduleVO> getList(ScheduleCriteria cri) {
		return mapper.getList(cri);
	}
	
	@Override
	public List<ScheduleVO> search(String keyword) {
	
		return mapper.search(keyword);
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
		boolean result1 = mapper.insertSchedule(scheduleVO) == 1;
		boolean result2 = false;
		int count = 0;
		for(String p : scheduleVO.getParticipant()) {
			scheduleVO.setEmp_id(p);
			mapper.insertParticipant(scheduleVO);
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
	public String getMemo(String memo) {
		return mapper.getMemo(memo);
	}

	// 메모 수정(등록)
	@Override
	public boolean updateMemo(String emp_id, String memo) {
		return mapper.updateMemo(emp_id, memo) == 1;
	}

}
