package org.shiftworks.controller;

import java.util.List;

import org.shiftworks.domain.BookingVO;
import org.shiftworks.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@RestController
@Log4j
@RequestMapping("/booking/*")
@AllArgsConstructor
public class BookingController {
	
	private BookingService service;
	
	@GetMapping("/new")
	public ModelAndView insertBooking() throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("booking/insertBookingForm");
		return mav;
	}
	
	@PostMapping(value = "/new", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> insertBooking(@RequestBody BookingVO vo) {
		
		log.info("insertBooking controller.............");
		service.insertBooking(vo);
		log.info(vo);
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	
	@GetMapping("/{book_id}")
	public BookingVO getBooking(@PathVariable("book_id") int book_id) {
		
		BookingVO vo = service.getBooking(book_id);
		
		return vo;
	}
	
	@GetMapping("/list")
	public List<BookingVO> getList() {
		List<BookingVO> list = service.getList();
		
		return list;
	}
	
	@GetMapping("/list/{emp_id}")
	public List<BookingVO> getMyList(@PathVariable("emp_id") String emp_id){
		log.info("getMyList controller....................");
		
		List<BookingVO> myList = service.getMyList(emp_id);
		log.info(myList);
		
		return myList;
	}
	
	@PostMapping("/{book_id}")
	public ResponseEntity<String> deleteBooking(@PathVariable("book_id") int book_id) {
		log.info("deleteBooking controller..................");
		int re = service.deleteBooking(6);
		log.info(re);
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	




}
