package org.shiftworks.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.shiftworks.domain.BookingVO;
import org.shiftworks.domain.ScheduleCriteria;
import org.shiftworks.domain.ScheduleVO;
import org.shiftworks.domain.WorkScheduleVO;

public interface ScheduleMapper {

	List<ScheduleVO> getList(ScheduleCriteria cri);
	List<ScheduleVO> search(@Param("keyword")String keyword, @Param("emp_id") String emp_id);
	
	ScheduleVO getSchedule(Integer sch_id);
	
	List<String> getParticipant(Integer sch_id);
	
	int insertSchedule(ScheduleVO scheduleVO);
	int insertParticipant(ScheduleVO scheduleVO);
	int updateSchedule(ScheduleVO scheduleVO);
	int deleteSchedule(Integer sch_id);
	int deleteParticipant(@Param("sch_id") Integer sch_id, @Param("emp_id") String emp_id);
	
	String getMemo(String emp_id);
	int updateMemo(@Param("emp_id") String emp_id, @Param("memo") String memo);
	
	List<WorkScheduleVO> getWorkerList(String dept_id);
	
	List<BookingVO> searchBooking(String keyword);
}
