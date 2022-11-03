package org.shiftworks.controller;

import org.shiftworks.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping("/manager/*")
@AllArgsConstructor
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/list")
	public void list(Model model) {
		
		log.info("list.............");
		model.addAttribute("list", service.getList());
		
	}
	
	
	
}
