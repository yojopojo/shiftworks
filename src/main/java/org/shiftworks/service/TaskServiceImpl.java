package org.shiftworks.service;

import java.util.List;

import org.shiftworks.domain.AlarmVO;
import org.shiftworks.domain.TaskCriteria;
import org.shiftworks.domain.TaskPageDTO;
import org.shiftworks.domain.TaskVO;
import org.shiftworks.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskMapper taskMapper;

	@Override
	public List<TaskVO> getList(TaskPageDTO taskPageDTO) {
	
		log.info("service: getlist..........");
		
		return taskMapper.getListWithPaging(taskPageDTO.getCri());
	}

	@Override
	public TaskVO getTask(Integer task_id) {
		
		log.info("service: getTask..........");
		
		return taskMapper.getTask(task_id);
	}

	@Override
	public boolean insertTask(TaskVO taskVO) {
		log.info("service: insertTask..........");
		return taskMapper.insertTask(taskVO) == 1;
	}

	@Override
	public boolean updateTask(TaskVO taskVO) {
		log.info("service: updateTask..........");
		return taskMapper.updateTask(taskVO) == 1;
	}

	@Override
	public boolean deleteTask(Integer task_id) {
		log.info("service: insertTask..........");
		return taskMapper.deleteTask(task_id) == 1;
	}

	@Override
	public boolean insertAlarm(AlarmVO alarmVO) {
		// TODO Auto-generated method stub
		return false;
	}

}
