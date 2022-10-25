package org.shiftworks.mapper;

import java.util.List;

import org.shiftworks.domain.ScheduleCriteria;
import org.shiftworks.domain.ScheduleVO;

public interface ScheduleMapper {

	List<ScheduleVO> getList(ScheduleCriteria cri);
	
	ScheduleVO getSchedule(Integer sch_id);
	
	boolean insertSchedule(ScheduleVO scheduleVO);
	boolean updateSchedule(ScheduleVO scheduleVO);
	boolean deleteSchedule(Integer sch_id);
	
	String getMemo();
	boolean updateMemo();
	
	//boolean insertAlarm(AlarmVO alarmVO);
}
