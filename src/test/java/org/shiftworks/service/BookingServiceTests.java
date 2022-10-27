package org.shiftworks.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.shiftworks.domain.BookingVO;
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
		
		BookingVO vo = new BookingVO();

	      try {
	    		String dateStr = "2022-10-25";
	    		log.info("date확인합니다...................................");
	            log.info(dateStr);
	            
	            // 포맷터        
	            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");         
	            // 문자열 -> Date
	            Date date = formatter.parse(dateStr);
	            log.info("formatter확인합니다..........................plz.......");
	            log.info(date);
	            
	            vo.setBook_date(date);
	        } catch (Exception e) {
	  			e.printStackTrace();
	  		}

		vo.setBook_id(17);
		vo.setBook_title("Service Test-insert3");
		vo.setBook_begin(9);
		vo.setRsc_id("CFR505");
		vo.setDept_id("SALES");
		vo.setEmp_id("SALES3056");
		//vo.setBook_date("2022/10/25");
		vo.setBook_content("insertBooking Service Test");

		int re = service.insertBookingCondition(vo);
		log.info(vo);
		log.info("vo결과값: (22/10/25...................................)"+re);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
