package org.shiftworks.mapper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
//		vo.setBook_id(18);
//		vo.setRsc_id("CFR307");
//		vo.setEmp_id("IMP3056");
//		vo.setDept_id("sales");
//		vo.setBook_begin(15);
//		vo.setBook_title("reserv mapper test3");
//		vo.setBook_content("123something something blah");
//		int re = mapper.insertBooking(vo);
//		log.info(vo);
//		log.info(re);
//	}
	
//	@Test
//	public void testGetBooking() {
//		log.info("get one booking by mapper.................");
//		BookingVO vo = mapper.getBooking(7);
//		log.info("날짜 데이터 확인: ----------------->"+vo.getBook_date());
//		log.info(vo);
//	}
	
//	@Test
//	public void testGetList() {
//		log.info("getList by mapper......................");
//		List<BookingVO> list = mapper.getList();
//		log.info(list);
//	}
	
//	@Test
//	public void testGetMyList() {
//		log.info("getMyList by mapper.......................");
//		List<BookingVO> myList = mapper.getMyList("IMP3056");
//		log.info(myList);
//	}
	
//	@Test
//	public void testDeleteBooking() {
//		log.info("deleteBooking by mapper...................");
//		int re = mapper.deleteBooking(6);
//		log.info(re);
//	}
	
	
	
//	@Test
//	public void testGetBookingList() {
//		log.info("get bookingList by mapper.................");
//		
//		//선택한 날짜, 자원
//		String selectDate = "2022-10-25";
//		String selectRsc = "CFR305";
//		//선택한 시간
//	    int selectTime = 15;
// 	    
//	    try {
////	       	// 포맷터        
////		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
////	    	Date selectBook_date = formatter.parse(selectDate);
////	    	log.info("자원조건(rsc_id): ----------------------------->"+selectRsc);
////	    	log.info("날짜조건(format된 날짜): ------------------------>"+selectBook_date);
//		    
//		    //선택된 날짜, 자원 parameter세팅
//		    BookingVO selectedVO = new BookingVO();
//		    selectedVO.setRsc_id(selectRsc);
//		    selectedVO.setBook_date(selectDate);
//
//		    //선택한 자원, 시간의 예약 리스트 불러오기
//		    List<BookingVO> bookingList = mapper.getBookingList(selectedVO);
//		    log.info("선택된 일자의 자원 예약목록 ----------------------------->"+bookingList);
//		    
//		    
//		    BookingVO newBooking = new BookingVO();
//		    newBooking.setBook_id(31);
//		    newBooking.setBook_date(selectDate);
//		    newBooking.setRsc_id(selectRsc);
//		    newBooking.setEmp_id("IMP3056");
//		    newBooking.setDept_id("sales");
//		    newBooking.setBook_begin(selectTime);
//		    newBooking.setBook_title("새로운 예약 중복 테스트");
//		    newBooking.setBook_content("plz don't");
//			log.info(newBooking);
//		    
//			boolean isAble = true;
//		
//		    for(int i=0;i<bookingList.size();i++) {
//		    	if(bookingList.get(i).getBook_begin() == selectTime) {
//		    		isAble = false;
//		    		return;
//		    	}
//		    }
//		    
//		    if(isAble == true) {
//		    	int num = mapper.insertBooking(newBooking);
//		    	log.info("예약 가능 및 예약 수----------------------->"+num);
//		    }else{
//		    	log.info("예약 불가능해용..............................");
//		    }
		    
		    	
//		    	if(bookingList.get(i).getBook_begin()==selectTime) {
//		    		log.info("----------------------------------예약 불가------------------------------");
//		    		return;
//		    	}
//		    	if(bookingList.get(i).getBook_begin()!=selectTime) {
//		    		log.info("----------------------------------예약 가능------------------------------");
//		    		int re = mapper.insertBooking(newBooking);
//		    		log.info("예약된 숫자: -------------------------------->"+re+"bookingList.get(i)"+i);
//		    		return;
//		    	}
//		    	}else{
//		    		log.info("----------------------------------예약 가능------------------------------");
//					int re = mapper.insertBooking(newBooking);
//					log.info("예약된 숫자: --------------------------->"+re);
//		    		return;
//		    	}
//		    	log.info("----------------------------------예약 불가-------------------------------");
//		    	return;
		    
		    
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	
	@Test
	public void testPage() {
		Criteria cri = new Criteria();
		cri.setPageNum(3);
		cri.setAmount(3);
		List<BookingVO> list = mapper.getListwithPaging(cri);
		list.forEach(booking -> log.info(booking));
	}
	
	
	
	

	
	
	
	
	
	
	
	
}
