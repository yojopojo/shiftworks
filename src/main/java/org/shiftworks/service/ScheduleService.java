package org.shiftworks.service;

import java.util.List;

import org.shiftworks.domain.ScheduleCriteria;
import org.shiftworks.domain.ScheduleVO;
import org.shiftworks.domain.WorkScheduleVO;

public interface ScheduleService {

	List<ScheduleVO> getList(ScheduleCriteria cri);
	List<ScheduleVO> search(String keyword, String emp_id);
	
	ScheduleVO getSchedule(Integer sch_id);
	
	boolean insertSchedule(ScheduleVO scheduleVO);
	boolean updateSchedule(ScheduleVO scheduleVO);
	boolean deleteSchedule(Integer sch_id, String emp_id);
	
	String getMemo(String emp_id);
	boolean updateMemo(String emp_id, String memo);
	
	List<WorkScheduleVO> getWorkerList(String dept_id);
	
}
