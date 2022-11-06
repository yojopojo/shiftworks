package org.shiftworks.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.shiftworks.domain.BoardVO;
import org.shiftworks.domain.BookingCriteria;
import org.shiftworks.domain.BookingPageDTO;
import org.shiftworks.domain.BookingVO;
import org.shiftworks.service.ApprovalService;
import org.shiftworks.service.BookingService;
import org.shiftworks.service.DocumentService;
import org.shiftworks.service.PostService;
import org.shiftworks.service.ScheduleService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping("/main/*")
@AllArgsConstructor
public class MainController {
	
	private BookingService bokService;
	private ApprovalService aprService;
	private DocumentService docService;
	private PostService boaService;
	private ScheduleService schService;
	
	
	@GetMapping("")
	public String get() {
		
		bokService.deleteBooking(0);
		log.info("test중.............");
		
		return "";
	}

	
	//getList 테스트 메서드(list만 가져오고 view없음) -> 리스트 출력은 ok, 달력에 출력은 x
	@GetMapping("")
	@PreAuthorize("isAuthenticated()")
	public List<Map<String, Object>> getCalbookings() {
		List<BookingVO> bookingList = bokService.getList();
		
		List<Map<String, Object>> calList = new ArrayList<Map<String,Object>>();

		for(int i=0;i<bookingList.size();i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			//map.put("start", bookingList.get(i).getBook_date());

			String begin = bookingList.get(i).getBook_begin();
			int getEndTime = Integer.parseInt(bookingList.get(i).getBook_begin())+2;
			String end = Integer.toString(getEndTime);
			
			map.put("title", bookingList.get(i).getBook_title());
			map.put("start", bookingList.get(i).getBook_date().substring(0, 10));
			/*
			 * map.put("end", bookingList.get(i).getBook_date().substring(0,
			 * 10)+"T"+end+":00");
			 */
			/* map.put("color", "red"); */
			/* map.put("backgroundColor", "#1C3359"); */
			calList.add(i, map);
			//calList.add(map);
		}
		//calList.add(map);

		return calList;
	}
	
	
	@GetMapping("/docList")
	@PreAuthorize("isAuthenticated()")
	public List<BoardVO> getList() {
		//List<BookingVO> list = service.getList();
		//ModelAndView mav = new ModelAndView();
//		log.info("list: "+cri);
//		mav.setViewName("booking/BOK_list");
//		mav.addObject("event", bokService.getListwithPaging(cri));
//		//mav.addObject("pageMaker", new BookingPageDTO(cri, 123));
//		
//		int total = bokService.getTotalCount(cri);
//		log.info("total: "+total);
//		mav.addObject("pageMaker", new BookingPageDTO(cri, total));
		
		
		List<BoardVO> list = boaService.getListSearch(null);
		
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
