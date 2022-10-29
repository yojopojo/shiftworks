package org.shiftworks.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.shiftworks.domain.BookingPageDTO;
import org.shiftworks.domain.BookingVO;
import org.shiftworks.domain.Criteria;
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

import com.google.gson.Gson;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@RestController
@Log4j
@RequestMapping("/booking/*")
@AllArgsConstructor
public class BookingController {
	
	private BookingService service;

	
	//getList 테스트 메서드(list만 가져오고 view없음)
	@GetMapping("/getCal2")
	public List<Map<String, Object>> getCalbookings() {
		List<BookingVO> bookingList = service.getList();
		
		List<Map<String, Object>> calList = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		for(int i=0;i<bookingList.size();i++) {
			map.put("title", bookingList.get(i).getBook_title());
			map.put("start", bookingList.get(i).getBook_date());
			
			calList.add(i, map);
		}
		
		return calList;
	}
	
	
	
	//예약1개 보기 테스트 메서드(booking만 반환, view없음)
	@GetMapping("/getCal")
	public Map<String, Object> getCal() {
		BookingVO getOne = service.getBooking(1);
		
		String bookdate = getOne.getBook_date();
		log.info(bookdate); //10개
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", getOne.getBook_title());
		map.put("start", getOne.getBook_date());
		
		return map;
		
		
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("booking/bookingList");
//		mav.addObject("event", service.getList());
		
//		JsonObject jsonObj = new JsonObject();
//		JsonArray jsonArr = new JsonArray();
//		
//		HashMap<String, Object> hash = new HashMap<String, Object>();
//		
//		for(int i=0; i<list.size();i++) {
//			hash.put("title", list.get(i).getBook_title());
//			hash.put("start", list.get(i).getBook_date());
//
//			jsonObj = new JsonObject(hash);
//			jsonArr.add(jsonObj);
//		}
//		log.info("jsonArr: "+jsonArr);
		
//		Map<String, Object> map = new HashMap<String, Object>();
//		for(int i=0;i<list.size();i++) {
//			map.put("title", list.get(i).getBook_title());
//			map.put("start", list.get(i).getBook_date());
//		}
//		
//		ArrayList<HashMap<String, Object>> resultList = new ArrayList<HashMap<String,Object>>();
//		resultList.add(null);
		
		//return map;
	}
	
	
	//calendar test method -> calendar view 출력용(list 못가져옴)
	@GetMapping("/cal")
	public ModelAndView getCalList() {
		ModelAndView mav = new ModelAndView();
		List<BookingVO> list = service.getList();
		log.info("list확인......................................>"+list);
		
		String json = new Gson().toJson(list);

		mav.setViewName("booking/bookingCal");
		mav.addObject("event", json);
		
		log.info("cal controller..........................mav.......................");
		log.info(mav);
		log.info("json결과: ---------------------------------------"+json);

		return mav;
	}
	
	
	//예약폼 페이지로 이동
	@GetMapping("/new")
	public ModelAndView insertBooking() throws Exception{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("booking/insertBookingForm");
		return mav;
	}
	
	//예약하기
	@PostMapping(value ="/new", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> insertBooking(@RequestBody BookingVO vo) {
		
		log.info("insertBooking controller.............");
		//service.insertBooking(vo);
		int re = service.insertBookingCondition(vo);
		log.info(vo);
		log.info(re);
		
		return re == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>("fail", HttpStatus.OK);
		//return new ResponseEntity<String>("success Reservation", HttpStatus.OK);
	}
	
	//예약 1개 상세보기
	@GetMapping("/{book_id}")
	public ModelAndView getBooking(@PathVariable("book_id") int book_id) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("booking/detail");
		mav.addObject("event", service.getBooking(book_id));
		
		return mav;
	}
	
	
	//전체 예약 현황보기(+페이징)(게시판 이동)
	@GetMapping("/list")
	public ModelAndView getList(Criteria cri, ModelAndView mav) {
		//List<BookingVO> list = service.getList();
		//ModelAndView mav = new ModelAndView();
		mav.setViewName("booking/bookingList");
		mav.addObject("event", service.getListwithPaging(cri));
		mav.addObject("pageMaker", new BookingPageDTO(cri, 23));
		
		return mav;
	}
	
	
//	//전체 예약 현황보기(게시판 이동)
//	@GetMapping("/list")
//	public ModelAndView getList() {
//		//List<BookingVO> list = service.getList();
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("booking/bookingList");
//		mav.addObject("event", service.getList());
//		
//		return mav;
//	}
	
	//내 예약 현황보기(게시판 형식)
	@GetMapping("/list/{emp_id}")
	public ModelAndView getMyList(@PathVariable("emp_id") String emp_id){
		log.info("getMyList controller....................");
		List<BookingVO> myList = service.getMyList(emp_id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("booking/bookingList");
		mav.addObject("event", myList);
		log.info(myList);
		
		return mav;
	}
	
	//예약 취소하기
	@PostMapping("/{book_id}")
	public ResponseEntity<String> deleteBooking(@PathVariable("book_id") int book_id) {
		log.info("deleteBooking controller..................");
		int re = service.deleteBooking(6);
		log.info(re);
		
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}
	




}
