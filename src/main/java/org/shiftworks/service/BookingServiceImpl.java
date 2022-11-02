package org.shiftworks.service;

import java.util.List;

import org.shiftworks.domain.BookingVO;
import org.shiftworks.domain.Criteria;
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
	
	//예약하기(+예약 중복 검증)
	@Override
	public int insertBookingCondition(BookingVO vo) {
		
		log.info("insertBooking Service with Condition...............");
		String selectRsc = vo.getRsc_id();
		String selectDate = vo.getBook_date();
		log.info("date형태 확인......................>"+selectDate);
		
		String selectTime = vo.getBook_begin();
		
		List<BookingVO> bookingList = mapper.getBookingList(vo);
		log.info("예약된 리스트 from Service------------------------->"+bookingList);
		
		boolean isAble = true;
		
		for(int i=0;i<bookingList.size();i++) {
			log.info("예약된 자원들의 시간 목록은...................."+bookingList.get(i).getBook_begin());
			log.info("선택한 시간은.............................."+selectTime);
	    	if(bookingList.get(i).getBook_begin().equals(selectTime)) {
	    		isAble = false;
	    	}
	    }
	    
	    if(isAble == true) {
	    	int re = mapper.insertBooking(vo);
	    	log.info("예약 가능! 예약된 자원----------------------->"+re+"개 입니다");
	    	return re;
	    }else{
	    	log.info("예약 불가능..............................");
	    	int re = -1;
	    	return re;
	    }
	    
	    
		//선택한 자원의 예약 목록...
//		if(selectRsc) {
//			
//		}
		//예약하려는 일자에 예약된 목록들 불러오기 -> 해당 목록들 중에서 예약자원코드와 시간이 같은 곳이면 예약불가
//		for(int i=0;i<list.size();i++) {
//			if(selectDate==list.get(i).getBook_date()&&selectTime==list.get(i).getBook_begin()) {
//				//날짜 체크&시작시간 체크
//					return -1;
//			}else if(selectDate!=list.get(i).getBook_date() || selectTime!=list.get(i).getBook_begin()){
//					int re = mapper.insertBooking(vo);
//					return re;
//				}
//			}//end for
//		int re = mapper.insertBooking(vo);
//		return re;
	}
	
	
	//예약하기
	@Override
	public int insertBooking(BookingVO vo) {
		log.info("insertBooking Service...............");
		
		int re = mapper.insertBooking(vo);
		
		return re;
	}

	
	//예약 상세 보기(1개)
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

	
	//예약 전체 현황(예약 리스트)
	@Override
	public List<BookingVO> getList() {
		log.info("getList Service.....................");
		List<BookingVO> list = mapper.getList();
		log.info(list);
		
		return list;
	}
	
	//내 예약 현황(내 예약 리스트)
	@Override
	public List<BookingVO> getMyList(String emp_id) {
		log.info("getMyList Service.................");
		List<BookingVO> myList = mapper.getMyList(emp_id);
		log.info(myList);
		
		return myList;
	}

	//예약 취소
	@Override
	public int deleteBooking(int book_id) {
		log.info("deleteBooking Service..............");
		int re = mapper.deleteBooking(book_id);
		
		return re;
	}

	//예약목록(페이징)
	@Override
	public List<BookingVO> getListwithPaging(Criteria cri) {
		log.info("get List with criteria from Service: "+cri);
		
		return mapper.getListwithPaging(cri);
	}

	//전체 예약 숫자 구하기
	@Override
	public int getTotalCount(Criteria cri) {
		log.info("get total count from Service");
		return mapper.getTotalCount(cri);
	}


}
