package org.shiftworks.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.shiftworks.domain.BookingVO;
import org.shiftworks.domain.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class BookingServiceTests {
	@Autowired
	public BookingService service;
	
//	@Test
//	public void insertBookingTest() {
//		log.info("insertBooking Testing..................");
//		
//		BookingVO vo = new BookingVO();
//		vo.setBook_id(14);
//		vo.setBook_title("Service Test-insert3");
//		vo.setBook_begin(9);
//		vo.setRsc_id("CFR505");
//		vo.setDept_id("SALES");
//		vo.setEmp_id("SALES3056");
//		//vo.setBook_date("2022/10/28");
//		vo.setBook_content("insertBooking Service Test");
//
//		service.insertBooking(vo);
//		log.info(vo);
//	}
	
//	@Test
//	public void getBookingTest() {
//		log.info("getBooking Testing.....................");
//		
//		BookingVO vo = service.getBooking(3);
//		log.info(vo);
//	}
	
//	@Test
//	public void getList() {
//		log.info("getList Testing........................");
//		List<BookingVO> list = service.getList();
//		log.info(list);
//	}
	
//	@Test
//	public void getMyList() {
//		log.info("getMyList Service Testing................");
//		List<BookingVO> myList = service.getMyList("IMP3056");
//		log.info(myList);
//	}
	
//	@Test
//	public void deleteBooking() {
//		log.info("deleteBooking Service Testing..............");
//		int re = service.deleteBooking(4);
//		log.info(re);
//	}
//	
	
	
	@Test
	public void insertBookingConditionTest() {
		log.info("insertBooking Condition Check Testing..................");
		
  		//선택한 자원, 날짜
  		String selectDate = "2022-12-25 09:00";
  		String selectRsc = "CFR305";
  		//선택한 시간
  	    int selectTime = 9;
  	    
  		BookingVO vo = new BookingVO();
  		//vo.setBook_id(32);
  		vo.setRsc_id(selectRsc);
  		vo.setDept_id("SALES");
  		vo.setEmp_id("SALES");
  		vo.setBook_begin(selectTime);
  		vo.setBook_date(selectDate);
  		vo.setBook_title("서비스 예약 테스트");
  		vo.setBook_content("서비스 테스트");
  		
  		service.insertBookingCondition(vo);
  		log.info("service.insertBookingCondition done---------------------------->"+vo);
  		log.info("date타입 확인 serviceTest................: "+selectDate);
//  		log.info(re);
//
//	      try {
//	    	  
//		  		
//	    		log.info("date확인합니다...................................");
//	            log.info(selectDate);
//	            
//	            // 포맷터        
//	            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");         
//	            // 문자열 -> Date
//	            Date date = formatter.parse(selectDate);
//	            log.info("formatter확인합니다..........................plz.......");
//	            log.info(date);
//	            
//	           // vo.setBook_date(date);
//	            
//
//	        } catch (Exception e) {
//	  			e.printStackTrace();
//	  		}
	      
	      
//		vo.setBook_id(17);
//		vo.setBook_title("Service Test-insert3");
//		vo.setBook_begin(9);
//		vo.setRsc_id("CFR505");
//		vo.setDept_id("SALES");
//		vo.setEmp_id("SALES3056");
//		//vo.setBook_date("2022/10/25");
//		vo.setBook_content("insertBooking Service Test");
//
//		int re = service.insertBookingCondition(vo);
//		log.info("vo결과값: (22/10/25...................................)"+re);
	}
	
	
//	@Test
//	public void testGetListPaging() {
//		service.getListwithPaging(new Criteria(2,4)).forEach(booking -> log.info(booking));
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
