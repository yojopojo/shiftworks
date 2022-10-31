package org.shiftworks.controller;

import java.lang.ProcessBuilder.Redirect;

import org.shiftworks.domain.ApprovalVO;
import org.shiftworks.domain.Criteria;
import org.shiftworks.service.ApprovalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/approval/*")
@AllArgsConstructor
public class ApprovalController {

	private ApprovalService service;
	
	// 결재 리스트
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		log.info("list" + cri);
		model.addAttribute("list", service.getList(cri));
	}
	
	// 결재 문서 작성
	@PostMapping("/insert")
	public String insert(ApprovalVO approval, RedirectAttributes rttr) {
		log.info("insert: "+ approval);
		service.insertForm(approval);
		
		rttr.addFlashAttribute("result",approval.getApr_id());
		return "redirect:/approval/list";
	}
	
	// 결재 문서 상세보기
	@GetMapping("/get")
	public void get(@RequestParam("apr_id") int apr_id, Model model) {
		log.info("/get");
		model.addAttribute("approval",service.get(apr_id));
	}
	
	// 결재 수정(결재 상태 수정)
	@PostMapping("/update")
	public String update(ApprovalVO approval, RedirectAttributes rttr) {
		log.info("update: "+approval);
		
		if (service.update(approval)) {
			rttr.addFlashAttribute("result", "success");			
		}
		return "redirect:/approval/list";
	}
	
	// 결재 양식 호출
	@GetMapping("/insert")
	public void insert() {}
	
	
	// 결재 처리(결재 상태 변경)
	@PutMapping("/sign/{apr_id}")
	@ResponseBody
	public ResponseEntity<String> updateStatus(@PathVariable int apr_id, @RequestParam String status){
		log.info("approval sign controller.......");
		log.info("apr_id : " + apr_id);
		
		service.updateStatus(apr_id, status);
		
		return new ResponseEntity<String>("ok", HttpStatus.OK);
	}
}
