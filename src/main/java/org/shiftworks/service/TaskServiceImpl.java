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

	// 검색, 페이징 포함 업무 목록 보기
	@Override
	public TaskPageDTO getList(TaskCriteria cri) {
		
		TaskPageDTO dto = new TaskPageDTO(cri, taskMapper.getTotalTask(cri));
	
		log.info("service: getlist..........");
		
		dto.setList(taskMapper.getListWithPaging(cri));
		
		return dto;
	}

	// 업무 개별 보기
	@Override
	public TaskVO getTask(Integer task_id) {
		
		log.info("service: getTask..........");
		
		return taskMapper.getTask(task_id);
	}

	// 업무 등록
	@Override
	public boolean insertTask(TaskVO taskVO) {
		log.info("service: insertTask..........");
		return taskMapper.insertTask(taskVO) == 1;
	}

	// 업무 수정
	@Override
	public boolean updateTask(TaskVO taskVO) {
		log.info("service: updateTask..........");
		return taskMapper.updateTask(taskVO) == 1;
	}

	// 업무 삭제
	@Override
	public boolean deleteTask(Integer task_id) {
		log.info("service: insertTask..........");
		return taskMapper.deleteTask(task_id) == 1;
	}

	// 알림 등록(미구현 상태)
	@Override
	public boolean insertAlarm(AlarmVO alarmVO) {
		// TODO Auto-generated method stub
		return false;
	}



}
