package org.shiftworks.mapper;

import java.util.List;

import org.shiftworks.domain.EmployeeVO;
import org.shiftworks.domain.TaskCriteria;
import org.shiftworks.domain.TaskVO;

public interface TaskMapper {

	public int getTotalTask(TaskCriteria cri);
	public List<TaskVO> getListWithPaging(TaskCriteria cri);
	
	public TaskVO getTask(Integer task_id);
	
	public int insertTask(TaskVO task);
	public int updateTask(TaskVO task);
	public int deleteTask(Integer task_id);
	
	List<EmployeeVO> getDeptMember(String dept_id);
}
