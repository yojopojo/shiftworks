package org.shiftworks.service;

import java.util.Date;
import java.util.List;

import org.shiftworks.domain.BookingVO;
import org.shiftworks.mapper.BookingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class BookingServiceImpl implements BookingService {
	@Autowired
	private BookingMapper mapper;
	
	
	@Override
	public int insertBookingCondition(BookingVO vo) {
		log.info("insertBooking Service...............");
		String selectRsc = vo.getRsc_id();
		Date selectDate = vo.getBook_date();
		int selectTime = vo.getBook_begin();
		List<BookingVO> list = mapper.getBookingList(selectDate);
		
		//선택한 자원의 예약 목록...
//		if(selectRsc) {
//			
//		}
		//예약하려는 일자에 예약된 목록들 불러오기 -> 해당 목록들 중에서 예약자원코드와 시간이 같은 곳이면 예약불가
		for(int i=0;i<list.size();i++) {
			if(selectDate==list.get(i).getBook_date()&&selectTime==list.get(i).getBook_begin()) {
				//날짜 체크&시작시간 체크
					return -1;
			}else if(selectDate!=list.get(i).getBook_date() || selectTime!=list.get(i).getBook_begin()){
					int re = mapper.insertBooking(vo);
					return re;
				}
			}
		int re = mapper.insertBooking(vo);
		
		return re;
	}
	
	

	@Override
	public int insertBooking(BookingVO vo) {
		log.info("insertBooking Service...............");
		int re = mapper.insertBooking(vo);
		
		return re;
	}

	@Override
	public BookingVO getBooking(int book_id) {
        
		log.info("getBooking Service..................");
		BookingVO vo = mapper.getBooking(book_id);
		log.info(vo);
        
//        try {
//    		String dateStr = vo.getBook_date();
//    		log.info("date확인합니다...................................");
//            log.info(dateStr);
//            
//            // 포맷터        
//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");         
//            // 문자열 -> Date
//            Date date = formatter.parse(dateStr);
//            log.info("formatter확인합니다..........................plz.......");
//            log.info(date);
//            
//            vo.setBook_date(date);
//        } catch (Exception e) {
//			e.printStackTrace();
//		}
        return vo;
	}

	@Override
	public List<BookingVO> getList() {
		log.info("getList Service.....................");
		List<BookingVO> list = mapper.getList();
		log.info(list);
		
		return list;
	}

	@Override
	public List<BookingVO> getMyList(String emp_id) {
		log.info("getMyList Service.................");
		List<BookingVO> myList = mapper.getMyList(emp_id);
		log.info(myList);
		
		return myList;
	}

	@Override
	public int deleteBooking(int book_id) {
		log.info("deleteBooking Service..............");
		int re = mapper.deleteBooking(book_id);
		
		return re;
	}

}
