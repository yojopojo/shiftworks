package org.shiftworks.controller;

import java.util.List;

import org.shiftworks.domain.PostVO;
import org.shiftworks.domain.ScrapVO;
import org.shiftworks.service.DocumentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/document/*")
public class DocumentController {
	
	private DocumentService service;
	

	//내가쓴 게시물 list
	@ResponseBody
	@GetMapping(value = "/myDoc/{emp_id}")
	public ModelAndView getMyDocumentList(@PathVariable("emp_id") String emp_id){
		
		log.info("mydoclist.........");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/document/DOC_mydoclist");
		mav.addObject("list", service.getMyDocumentList(emp_id));
		
		return mav;
	}
	
	
	//내가 쓴 게시물 상세보기 
	@ResponseBody
	@GetMapping(value = "/detail")
	public ModelAndView getMyDocument(@RequestParam("post_id")int post_id){
		
		log.info("mydoc........");
		
		PostVO vo = new PostVO();
		vo.setPost_id(post_id);
		vo.setEmp_id("2"); 	//세션 구현 후 지워야 할 부분 
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/document/DOC_mydoc");
		mav.addObject("post", service.getMyDocument(vo));
		
		return mav;
		
	}
	
	
	//스크랩한 게시물 리스트 보기
	@ResponseBody
	@GetMapping(value = "/scrap/{emp_id}")
	public ModelAndView getScrapList(@PathVariable("emp_id") String emp_id){
		
		log.info("scraplist.........");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/document/DOC_scraplist");
		mav.addObject("list", service.getScrapList(emp_id));
		
		return mav;
	}
	
	
	//스크랩 상세보기
	@ResponseBody
	@GetMapping(value = "/scrapDetail")
	public ModelAndView getScrap(@RequestParam("post_id")int post_id){
		
		log.info("scrap........");
		
		ScrapVO vo = new ScrapVO();
		vo.setPost_id(post_id);
		vo.setEmp_id("12"); 	//세션 구현 후 지워야 할 부분 
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/document/DOC_scrap");
		mav.addObject("post", service.getScrap(vo));
		
		return mav;
		
	}

}
