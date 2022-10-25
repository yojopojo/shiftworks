package org.shiftworks.controller;

import java.util.List;

import org.shiftworks.domain.TaskCriteria;
import org.shiftworks.domain.TaskPageDTO;
import org.shiftworks.domain.TaskVO;
import org.shiftworks.service.TaskService;
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

	private TaskService service;
	
	// 검색기능 적용 페이징 처리
	@GetMapping(value="/pages/{dept_id}/{category}/{type}/{keyword}/{pageNum}",
				produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<TaskVO>> getList(
			@PathVariable() String dept_id, @PathVariable String category, @PathVariable String type,
			@PathVariable String keyword, @PathVariable Integer pageNum) {
		
		log.info("Controller: getList.........");
		
		if(dept_id == "all") {
			dept_id = null;
		}
		if(category == "all") {
			category = null;
		}
		if(type == "empty") {
			type = null;
		}
		if(keyword == "empty") {
			keyword = null;
		}
		
		// 검색 설정과 일치하는 로우 페이징처리하여 가져오기
		TaskCriteria cri = new TaskCriteria(pageNum, type, keyword, category, keyword);
		TaskPageDTO dto = service.getList(cri);
		
		return new ResponseEntity<List<TaskVO>>(dto.getList(), HttpStatus.OK);
	}
	
	// 업무 개별 보기
	@GetMapping(value="/pages/{dept_id}/{category}/{type}/{keyword}/{pageNum}/{task_id}",
				produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<TaskVO> getTask(
			@PathVariable() String dept_id, @PathVariable String category, @PathVariable String type,
			@PathVariable String keyword, @PathVariable Integer pageNum, @PathVariable Integer task_id, Model model) {
		
		model.addAttribute("category", category);
		model.addAttribute("type", type);
		model.addAttribute("keyword", keyword);
		model.addAttribute("pageNum", pageNum);
		
		return new ResponseEntity<TaskVO>(service.getTask(task_id), HttpStatus.OK);
	}
	
	@GetMapping(value="/new")
	public void insertForm() {
		
	}
	
	// 업무 등록
	@PostMapping(
			value="/new",
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> insertTask(@RequestBody TaskVO vo, Model model) {
		
		// 등록 후 해당 카테고리, 부서로 페이징
		model.addAttribute("category", vo.getCategory());
		model.addAttribute("dept_id", vo.getDept_id());
	
		return service.insertTask(vo) ?
			new ResponseEntity<String>("success", HttpStatus.OK) :
			new ResponseEntity<String>("a", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 업무 수정
	@RequestMapping(method = {RequestMethod.PATCH, RequestMethod.PUT},
				value="/pages/{dept_id}/{category}/{type}/{keyword}/{pageNum}/{task_id}",
				produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> updateTask(@RequestBody TaskVO vo,
			@PathVariable() String dept_id, @PathVariable String category, @PathVariable String type,
			@PathVariable String keyword, @PathVariable Integer pageNum, @PathVariable Integer task_id, Model model) {
		
		
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
