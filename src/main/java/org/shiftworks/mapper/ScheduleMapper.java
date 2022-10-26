package org.shiftworks.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.shiftworks.domain.ScheduleCriteria;
import org.shiftworks.domain.ScheduleVO;

public interface ScheduleMapper {

	List<ScheduleVO> getList(ScheduleCriteria cri);
	List<ScheduleVO> search(ScheduleCriteria cri);
	
	ScheduleVO getSchedule(Integer sch_id);
	
	boolean insertSchedule(ScheduleVO scheduleVO);
	boolean insertParticipant(ScheduleVO scheduleVO);
	boolean updateSchedule(ScheduleVO scheduleVO);
	boolean deleteSchedule(Integer sch_id);
	boolean deleteParticipant(@Param("sch_id") Integer sch_id, @Param("emp_id") String emp_id);
	
	String getMemo(String emp_id);
	boolean updateMemo(@Param("emp_id") String emp_id, @Param("memo") String memo);
	
	//boolean insertAlarm(AlarmVO alarmVO);
}
