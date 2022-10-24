package org.shiftworks.service;

import java.util.List;

import org.shiftworks.domain.AlarmVO;
import org.shiftworks.domain.TaskPageDTO;
import org.shiftworks.domain.TaskVO;

public interface TaskService {
	
	List<TaskVO> getList(TaskPageDTO taskPageDTO);
	TaskVO getTask(Integer task_id);
	boolean insertTask(TaskVO taskVO);
	boolean updateTask(TaskVO taskVO);
	boolean deleteTask(Integer task_id);
	
	boolean insertAlarm(AlarmVO alarmVO);
}
