package org.shiftworks.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.shiftworks.domain.BookingVO;

public interface BookingMapper {
	
//	@Select("SELECT * FROM rsc_booking")
//	public String getBooking();
	
	public String getBooking2();
	
	//예약하기
	public int insertBooking(BookingVO vo);
	//예약목록불러오기(예약 중복 조건 비교)
	public List<BookingVO> getBookingList(BookingVO vo);
	
	
	public BookingVO getBooking(int book_id);
	public List<BookingVO> getList();
	public List<BookingVO> getMyList(String emp_id);
	public int deleteBooking(int book_id);
	
}
