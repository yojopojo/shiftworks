package org.shiftworks.service;

import java.util.List;

import org.shiftworks.domain.AlarmVO;
import org.shiftworks.domain.EmployeeVO;
import org.shiftworks.domain.TaskCriteria;
import org.shiftworks.domain.TaskPageDTO;
import org.shiftworks.domain.TaskVO;
import org.shiftworks.mapper.AlarmMapper;
import org.shiftworks.mapper.FileMapper;
import org.shiftworks.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskMapper taskMapper;
	
	@Autowired
	private FileMapper fileMapper;
	
	@Autowired
	private AlarmMapper alarmMapper;

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
		
		// 게시글 정보 가져오기
		TaskVO vo = taskMapper.getTask(task_id);
		// 게시글의 파일 목록 가져오기
		vo.setFileList(fileMapper.selectTaskFile(task_id));
		
		return vo;
	}

	// 업무 등록
	@Transactional
	@Override
	public boolean insertTask(TaskVO taskVO) {
		log.info("service: insertTask..........");
		boolean result = taskMapper.insertTask(taskVO) == 1;
		
		
		// 업로드된 파일이 없을 경우 메소드 종료
		if (taskVO.getFileList() == null || taskVO.getFileList().size() <= 0) {
			return result;
		}
		// 파일 목록을 차례로 DB에 등록
		taskVO.getFileList().forEach(file -> {
			fileMapper.insertTaskFile(file);
		});
		
		// 부서원들에게 부서 업무에 대한 알림 생성
		List<EmployeeVO> list = taskMapper.getDeptMember(taskVO.getDept_id());
		for(EmployeeVO e : list) {
			AlarmVO alarm = new AlarmVO();
			alarm.setEmp_id(e.getEmp_id());
			alarm.setDept_id(e.getDept_id());
			alarm.setContent("[" + taskVO.getTask_title() + "] 업무가 등록되었습니다.");
			
			alarmMapper.insertAlarm(alarm);
		}
		
		return result;
	}

	// 업무 수정
	@Override
	public boolean updateTask(TaskVO taskVO) {
		log.info("service: updateTask..........");
		boolean result = taskMapper.updateTask(taskVO) == 1;
		return result;
	}

	// 업무 삭제
	@Transactional
	@Override
	public boolean deleteTask(Integer task_id) {
		log.info("service: insertTask..........");
		boolean result = taskMapper.deleteTask(task_id) == 1;
		return result;
	}




}
