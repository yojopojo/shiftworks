package org.shiftworks.controller;

import org.shiftworks.domain.AccountCriteria;
import org.shiftworks.domain.EmployeeVO;
import org.shiftworks.domain.AccountPageDTO;
import org.shiftworks.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/manager/*")
@AllArgsConstructor
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	

//	@GetMapping("/list")
//	public void list(Criteria cri, Model model) {
//		log.info("list11.............."+cri);
//		int total = service.getTotal(cri);
//		log.info("total: " + total);
//		model.addAttribute("list", service.getList(cri));
//		model.addAttribute("pageMaker", new PageDTO(cri, total));
//		
//	}
	
	@GetMapping("/list")
	public void list(Model model) {
		
//		int total = service.getTotal(cri);
//		log.info("total: " + total);
		log.info("list00.......");
		model.addAttribute("list", service.getList());
		log.info("list11.............."+model);
		//model.addAttribute("pageMaker", new PageDTO(cri, total));
		
	}
	
	//계정등록 get
	@GetMapping("/register")
	public void register() {
		
	}
	//계정등록 post
	@PostMapping("/register")
	public String register(EmployeeVO empVO, RedirectAttributes rttr){
		String inputPass=empVO.getPassword();
		String pwd=pwdEncoder.encode(inputPass);
		empVO.setPassword(pwd);
		
		log.info("ready register......................")
		service.register(empVO);
		log.info("register..............1" + empVO);
		rttr.addFlashAttribute("result", empVO.getEmp_id());
		
		return "redirect:/manager/list";
		
	}
	

	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("emp_id") String emp_id, Model model) {
		log.info("get..............");
		model.addAttribute("empID", service.get(emp_id));		
	}
	
	//계정 정보 수정
	@PostMapping("/modify")
	public String modify(EmployeeVO empVO, RedirectAttributes rttr) {
		String inputPass=empVO.getPassword();
		String pwd=pwdEncoder.encode(inputPass);
		empVO.setPassword(pwd);
	log.info("modify.............................");
	if(service.modify(empVO)) {
		rttr.addFlashAttribute("result", "success");
	}
	
	return "redirect:/manager/list";
}
//	public String modify(EmployeeVO empVO, @ModelAttribute("cri") Criteria cri,
//				RedirectAttributes rttr) {
//		log.info("modify.............................");
//		if(service.modify(empVO)) {
//			rttr.addFlashAttribute("result", "success");
//		}
//		
//		rttr.addAttribute("pageNum",cri.getPageNum());
//		rttr.addAttribute("amount",cri.getAmount());
//		
//		return "redirect:/manager/list";
//	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("emp_id") String emp_id, 
			@ModelAttribute AccountCriteria cri, RedirectAttributes rttr) {
		log.info("remove............."+emp_id);
		if(service.remove(emp_id)) {
			rttr.addAttribute("result", "success");
		}
		rttr.addFlashAttribute("pageNum", cri.getPageNum());
		rttr.addFlashAttribute("amount", cri.getAmount());
		
		return "redirect:/manager/list";
	}
	
	
}
