package org.shiftworks.mapper;

import java.util.List;

import org.shiftworks.domain.AlarmVO;

public interface AlarmMapper {
	int insertAlarm(AlarmVO alarmVO);
	List<AlarmVO> getAlarm(String emp_id);
	int deleteAlarm(Integer alarm_id);
	int insertDday(AlarmVO alarmVO);
}
