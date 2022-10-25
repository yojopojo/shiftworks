package org.shiftworks.mapper;

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
public class BookingMapperTests {
	@Autowired
	private BookingMapper mapper;
	
//	@Test
//	public void testGet() {
//		log.info("testing.........................................");
//		log.info(mapper.getClass().getName());
//		
//		log.info("getBooking.........................");
//		log.info(mapper.getBooking());
//		log.info("getBooking2.........................");
//		log.info(mapper.getBooking2());
//	}
	
//	@Test
//	public void testInsert() {
//		log.info("insert Testing......................................");
//		
//		BookingVO vo = new BookingVO();
//		vo.setBook_id(5);
//		vo.setRsc_id("CFR305");
//		vo.setDept_id("IMP");
//		vo.setEmp_id("IMP3056");
//		vo.setBook_date("2022-10-25");
//		vo.setBook_begin(10);
//		vo.setBook_title("reserv mapper test");
//		vo.setBook_content("something something blah");
//		int re = mapper.insertBooking(vo);
//		log.info(vo);
//		log.info(re);
//	}
	
	@Test
	public void testGetBooking() {
		log.info("get one booking by mapper.................");
		mapper.getBooking(3);
	}
	
	
	
	
}
