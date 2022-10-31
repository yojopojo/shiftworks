package org.shiftworks.controller;

import java.util.List;

import org.shiftworks.domain.TaskCriteria;
import org.shiftworks.domain.TaskPageDTO;
import org.shiftworks.domain.TaskVO;
import org.shiftworks.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("/task/*")
@AllArgsConstructor
public class TaskController {

	@Autowired
	private TaskService service;
	
	@GetMapping(value="/main")
	public ModelAndView main() {
		
		ModelAndView mav = new ModelAndView("/task/TSK_list");

		return mav;
		
	}
	
	// 검색기능 적용 페이징 처리
	@GetMapping(value="/pages/{dept_id}/{type}/{keyword}/{pageNum}")
	public ModelAndView getList(
			@PathVariable String dept_id, @PathVariable String type,
			@PathVariable String keyword, @PathVariable Integer pageNum) {
		
		log.info("Controller: getList.........");

		// 출력 페이지
		ModelAndView mav = new ModelAndView("/task/TSK_list");
		
		// 검색 조건 없을 경우 null 대입
		if(dept_id.equals("all")) {
			dept_id = null;
		}
		if(type.equals("empty")) {
			type = null;
		}
		if(keyword.equals("empty")) {
			keyword = null;
		}
		
		// 검색 설정과 일치하는 로우 페이징처리하여 가져오기
		TaskCriteria cri = new TaskCriteria(pageNum, type, keyword, dept_id);
		
		mav.addObject("dto", service.getList(cri));
		
		return mav;
	}
	
	// 업무 개별 보기
	@GetMapping(value="/pages/{dept_id}/{type}/{keyword}/{pageNum}/{task_id}")
	public ModelAndView getTask(
			@PathVariable() String dept_id, @PathVariable String type, @PathVariable String keyword,
			@PathVariable Integer pageNum, @PathVariable Integer task_id) {
		
		ModelAndView mav = new ModelAndView("/task/TSK_get");
		
		mav.addObject("type", type);
		mav.addObject("keyword", keyword);
		mav.addObject("pageNum", pageNum);
		mav.addObject("task", service.getTask(task_id));
		
		return mav;
	}
	
	// 업무 등록 폼으로 이동
	@GetMapping(value="/new")
	public ModelAndView insertForm() {
		
		ModelAndView mav = new ModelAndView("/task/TSK_new");
		
		return mav;
		
	}
	
	// 업무 등록
	@PostMapping(value="/new")
	public ResponseEntity<String> insertTask(@RequestBody TaskVO vo) {

		return service.insertTask(vo) ?
			new ResponseEntity<String>("success", HttpStatus.OK) :
			new ResponseEntity<String>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 업무 수정
	@RequestMapping(method = {RequestMethod.PATCH, RequestMethod.PUT},
				value="/pages/{dept_id}/{type}/{keyword}/{pageNum}/{task_id}",
				produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> updateTask(@RequestBody TaskVO vo,
			@PathVariable String dept_id, @PathVariable String type, @PathVariable String keyword,
			@PathVariable Integer pageNum, @PathVariable Integer task_id, Model model) {

		return service.updateTask(vo) ?
				new ResponseEntity<String>("success", HttpStatus.OK) :
				new ResponseEntity<String>("a", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 업무 삭제
	@DeleteMapping(
			value="/{task_id}",
				produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> deleteTask(@PathVariable Integer task_id) {
		
		return service.deleteTask(task_id) ?
				new ResponseEntity<String>("success", HttpStatus.OK) :
				new ResponseEntity<String>("a", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
