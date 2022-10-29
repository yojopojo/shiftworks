package org.shiftworks.controller;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.shiftworks.domain.Criteria;

import org.shiftworks.domain.PageDTO;
import org.shiftworks.domain.PostVO;
import org.shiftworks.domain.ScrapVO;
import org.shiftworks.domain.Temp_BoardVO;
import org.shiftworks.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/board/*")
@Controller
@Log4j
@AllArgsConstructor
public class PostController {
	
	
	private PostService service;
	
	//register form 이동
	@ResponseBody
	@GetMapping(value = "/new")
	public ModelAndView register() throws Exception{
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/board/BOA_register");
		return mav;
	}
	
	//register form에서 받아온 값 db에 넣기
	@ResponseBody
	@PostMapping(value = "/new")
	public ResponseEntity<String> register(@RequestBody PostVO vo){
		log.info("controller..............................");
		int insertCount = service.insertPost(vo);
		log.info("insertCount: " + insertCount);
		
		return insertCount ==1
		? new ResponseEntity<String>("success", HttpStatus.OK)
		: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	//BOA_list.jsp 호출
	@GetMapping(value = "/BOA_list")
	public void getList(Criteria cri, Model model) {
		
		log.info("getList..........");
		model.addAttribute("pageMaker", new PageDTO(cri, service.getTotal(), service.getListSearch(cri)));
	}
	
	
	//글번호 클릭 시 BOA_get.jsp로 이동
	@RequestMapping(method = RequestMethod.GET, value = "/getPost")
	public ModelAndView getPost(@RequestParam("post_id") int post_id, 
							  @ModelAttribute("cri") Criteria cri) throws Exception{
		log.info("get.........");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/board/BOA_get");
		mav.addObject("post", service.getPost(post_id));
		return mav;
	}
	
	//수정 클릭 시 BOA_modify.jsp로 이동
		@RequestMapping(method = RequestMethod.GET, value = "/modify")
		public ModelAndView modify(@RequestParam("post_id") int post_id, 
								  @ModelAttribute("cri") Criteria cri) throws Exception{
			log.info("modify.........");
			ModelAndView mav = new ModelAndView();
			mav.setViewName("/board/BOA_modify");
			mav.addObject("post", service.getPost(post_id));
			return mav;
		}
	
	// 수정 데이터 값을 db 넣기
	@PostMapping(value = "/modify")
	public String modify(PostVO post,
				@ModelAttribute("cri") Criteria cri, RedirectAttributes rttr){
		
//		vo.setPost_id(post_id);
//		return service.updatePost(vo)==1
//		? new ResponseEntity<String>("success", HttpStatus.OK)
//		: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		log.info("modify..................");
		if(service.updatePost(post)==1) {
			rttr.addFlashAttribute("result","success");
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount",cri.getAmount());
		
		return "redirect:/board/BOA_list";
		
	}
	
	//삭제하기
	@DeleteMapping(value = "/{post_id}")
	public ResponseEntity<String> deletePost(@PathVariable("post_id")int post_id){
		
		 return service.deletePost(post_id) ==1
		? new ResponseEntity<String>("success", HttpStatus.OK)
		: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	//스크랩하기
	@ResponseBody
	@PostMapping(value="/scrap")
	public ResponseEntity<String> scrapPost(@RequestBody ScrapVO vo){
		log.info("scrap..........");
	
		
		return service.scrapPost(vo)==1
		? new ResponseEntity<String>("scraped!", HttpStatus.OK)
		: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	//임시저장/업데이트하기 
	@ResponseBody
	@PostMapping(value = "/temporal")
	public ResponseEntity<String> temporalPost(@RequestBody Temp_BoardVO vo){
		log.info("temporal......");
		
		return service.temporalPost(vo)==1
		? new ResponseEntity<String>("temporal success",HttpStatus.OK)
		: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	//임시저장 불러오기 
	//추후 session 넣고나면 register 눌렀을 때 임시저장 불러오도록 구현 
	@ResponseBody
	@GetMapping(value = "/temporal/{b_id}")
	public ResponseEntity<Temp_BoardVO> temporalSelect(@PathVariable("b_id") int b_id){
		log.info("temporalSelect.....");
		
		Temp_BoardVO vo = new Temp_BoardVO();
		vo.setB_id(b_id);
		return new ResponseEntity<Temp_BoardVO>(service.temporalSelect(vo),HttpStatus.OK);
	}
	
	

}
