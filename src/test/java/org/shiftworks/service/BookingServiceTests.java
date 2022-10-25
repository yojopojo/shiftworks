package org.shiftworks.service;

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
//		vo.setBook_id(4);
//		vo.setBook_title("예약 테스트_한글");
//		vo.setBook_begin(9);
//		vo.setRsc_id("CFR305");
//		vo.setDept_id("IMP");
//		vo.setEmp_id("IMP3056");
//		vo.setBook_date("2022-10-25");
//		vo.setBook_content("한글_예약_테스트");
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
	
	@Test
	public void getMyList() {
		log.info("getMyList Service Testing................");
		List<BookingVO> myList = service.getMyList("IMP3056");
		log.info(myList);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
