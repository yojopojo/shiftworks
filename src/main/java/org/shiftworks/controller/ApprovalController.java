package org.shiftworks.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.shiftworks.domain.ApprovalVO;
import org.shiftworks.domain.ApprovalCriteria;
import org.shiftworks.domain.ApprovalPageDTO;
import org.shiftworks.domain.TempApprovalVO;
import org.shiftworks.service.ApprovalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Controller
@Log4j
@RequestMapping("/approval/*")
@AllArgsConstructor
public class ApprovalController {

	private ApprovalService service;
	
	
	/*
	 * 전자결재 메인 페이지
	*/
	@GetMapping("/main")
	@PreAuthorize("isAuthenticated()")
	public void approvalMain() {
		
	}
	
	/*
	 * 결재 리스트
	 */
	@GetMapping("/list")
	@PreAuthorize("isAuthenticated()")
	public void list(ApprovalCriteria cri, Model model) {
		log.info("list" + cri);
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pageMaker", new ApprovalPageDTO(cri, service.getTotal()));
	}
	
	
	/*
	 * 결재할 문서함 
	 */	
	@GetMapping("/receivedList")
	@PreAuthorize("isAuthenticated()")
	public void receivedList(ApprovalCriteria cri, Model model) {
		log.info("list" + cri);
		model.addAttribute("list", service.getReceivedList(cri));
		model.addAttribute("pageMaker", new ApprovalPageDTO(cri, service.getReceivedTotal()));
	}
	
	/*
	 * 결재 문서 작성
	 */
	@PostMapping("/insert")
	@PreAuthorize("isAuthenticated()")
	public String insert(ApprovalVO approval, RedirectAttributes rttr) {
		log.info("insert: "+ approval);
		service.insertForm(approval);
		
		rttr.addFlashAttribute("result",approval.getApr_id());
		return "redirect:/approval/list";
	}
	
	/*
	 * 결재 문서 상세보기
	 */ 
	@GetMapping("/get")
	@PreAuthorize("isAuthenticated()")
	public void get(@RequestParam("apr_id") int apr_id, Model model) {
		log.info("/get");
		model.addAttribute("approval",service.get(apr_id));
	}
	
	/*
	 * 결재 수정(결재 상태 수정)
	 */ 
	@PostMapping("/update")
	@PreAuthorize("isAuthenticated()")
	public String update(ApprovalVO approval, RedirectAttributes rttr) {
		log.info("update: "+approval);
		
		if (service.update(approval)) {
			rttr.addFlashAttribute("result", "success");			
		}
		return "redirect:/approval/list";
	}
	
	/*
	 * 결재 양식 호출
	 */
	@GetMapping("/insert")
	@PreAuthorize("isAuthenticated()")
	public void insert() {
	
	}
	
	/*
	 * 결재 처리(결재 상태 변경)
	 */
	@PutMapping("/sign/{apr_id}")
	@ResponseBody
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<String> updateStatus(@PathVariable int apr_id, @RequestBody ApprovalVO approval){
		log.info("approval sign controller.......");
		
		approval.setApr_id(apr_id);
		
		log.info("approval : " + approval);
		
		service.update(approval);
		
		return new ResponseEntity<String>("ok", HttpStatus.OK);
	}
	
	
	/*
	 임시저장 업데이트 하기
	*/
	@PostMapping("/temporal")
	@ResponseBody
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<String> temporalPost(@RequestBody TempApprovalVO vo){
		log.info("vo : " + vo);
		log.info("temporal.....");
		
		service.temporalApr(vo);
		
		return new ResponseEntity<String>("ok", HttpStatus.OK);
	}
	
	/*
	 임시저장 목록 불러오기
	*/
	@GetMapping(value="/tempList", produces="application/json; charSet=UTF-8")
	@ResponseBody
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<TempApprovalVO>> tempList(@RequestParam String emp_id){
		
		log.info("emp_id : " + emp_id);
		
		return new ResponseEntity<List<TempApprovalVO>>(service.tempList(emp_id), HttpStatus.OK);
	
	}
	
	/*
	 임시저장 선택?
	*/
	@GetMapping(value="/tempSelect/{temp_id}", produces="application/json; charSet=UTF-8")
	@ResponseBody
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<TempApprovalVO> tempSelect(@PathVariable int temp_id){
		
		log.info("tempSelect.....tempId : " + temp_id);
		
		return new ResponseEntity<TempApprovalVO>(service.tempSelect(temp_id), HttpStatus.OK);
	}
	
	
	/*
	 임시저장 불러오기
	*/
//	@GetMapping(value = "/temporal")
//	public ResponseEntity<TempApprovalVO> temporalSelect(){
//		log.info("temporalSelect.....");
//		
//		String emp_id = "user1";
//		
//		return new ResponseEntity<TempApprovalVO>(service.temporalSelect(emp_id),HttpStatus.OK);
//	}
	

	/*
	 임시저장 뷰
	 session 추가 후 결재문서 작성(insert) 시 임시저장 불러오도록 구현
	*/
//	@GetMapping(value = "temporalview")
//	public ModelAndView temporalview() {
//		log.info("temporalSelect......");
//		
//		String emp_id = "user1";
//		
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("/approval/insert");
//		mav.addObject("post", service.temporalSelect(emp_id));
//		return mav;
//	}
}
