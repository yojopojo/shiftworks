package org.shiftworks.controller;

import java.lang.ProcessBuilder.Redirect;

import org.shiftworks.domain.ApprovalVO;
import org.shiftworks.service.ApprovalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/approval/*")
@AllArgsConstructor
public class ApprovalController {

	private ApprovalService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list");
		model.addAttribute("list", service.getList());
	}
	
	@GetMapping("/get")
	public void get(@RequestParam("apr_id") int apr_id, Model model) {
		log.info("/get");
		model.addAttribute("approval",service.get(apr_id));
	}
	
	@PostMapping("/update")
	public String update(ApprovalVO approval, RedirectAttributes rttr) {
		log.info("update: "+approval);
		
		if (service.update(approval)) {
			rttr.addFlashAttribute("result", "success");			
		}
		return "redirect:/approval/list";
	}
}
