package org.shiftworks.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.shiftworks.domain.BookingVO;

public interface BookingMapper {
	
//	@Select("SELECT * FROM rsc_booking")
//	public String getBooking();
	
	public String getBooking2();
	
	public int insertBooking(BookingVO vo);
	public BookingVO getBooking(int rsc_id);
	public List<BookingVO> getList();
	public List<BookingVO> getMyList(String emp_id); 
	
}
