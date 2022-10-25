package org.shiftworks.controller;

import java.util.List;

import org.shiftworks.domain.TaskCriteria;
import org.shiftworks.domain.TaskPageDTO;
import org.shiftworks.domain.TaskVO;
import org.shiftworks.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("/task/*")
@AllArgsConstructor
public class TaskController {

	private TaskService service;
	
	// 검색기능 적용 페이징 처리
	@GetMapping("/pages/{dept_id}/{category}/{type}/{keyword}/{pageNum}")
	public ResponseEntity<TaskPageDTO> getList(
			@PathVariable String dept_id, @PathVariable String category, @PathVariable String type,
			@PathVariable String keyword, @PathVariable Integer pageNum) {
		
		log.info("Controller: getList.........");
		
		// 검색 설정과 일치하는 로우만 가져오기
		TaskCriteria cri = new TaskCriteria(pageNum, type, keyword);
		TaskPageDTO dto = service.getList(cri);
		
		// 일치하는 로우 개수 세서 페이징 처리
		return new ResponseEntity<TaskPageDTO>(
				dto, HttpStatus.OK);
	}
	
}
