package org.shiftworks.service;

import java.util.List;

import org.shiftworks.domain.BookingVO;
import org.shiftworks.domain.Criteria;

public interface BookingService {
	//예약하기
	public int insertBooking(BookingVO vo);
	//예약(+조건식)
	public int insertBookingCondition(BookingVO vo);
	//예약 상세보기(1개)
	public BookingVO getBooking(int book_id);
	
	//전체 예약목록
	public List<BookingVO> getList();
	//전체 예약목록(페이징)
	public List<BookingVO> getListwithPaging(Criteria cri);
	//전체 예약 숫자 구하기
	public int getTotalCount(Criteria cri);
		
		
	//내 예약목록 보기
	public List<BookingVO> getMyList(String emp_id);
	public int deleteBooking(int book_id);
	
	


}
