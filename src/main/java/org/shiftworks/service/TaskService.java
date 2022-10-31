package org.shiftworks.service;

import org.shiftworks.domain.TaskCriteria;
import org.shiftworks.domain.TaskPageDTO;
import org.shiftworks.domain.TaskVO;

public interface TaskService {
	
	TaskPageDTO getList(TaskCriteria cri);
	TaskVO getTask(Integer task_id);
	boolean insertTask(TaskVO taskVO);
	boolean updateTask(TaskVO taskVO);
	boolean deleteTask(Integer task_id);

}
