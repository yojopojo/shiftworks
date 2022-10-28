package org.shiftworks.service;

import java.util.List;

import org.shiftworks.domain.BookingVO;

public interface BookingService {
	//예약하기
	public int insertBooking(BookingVO vo);
	//예약(+조건식)
	public int insertBookingCondition(BookingVO vo);
	
	public BookingVO getBooking(int book_id);
	public List<BookingVO> getList();
	public List<BookingVO> getMyList(String emp_id);
	public int deleteBooking(int book_id);
	
	


}
