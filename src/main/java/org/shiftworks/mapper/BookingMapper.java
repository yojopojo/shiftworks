package org.shiftworks.mapper;

import org.apache.ibatis.annotations.Select;
import org.shiftworks.domain.BookingVO;

public interface BookingMapper {
	
//	@Select("SELECT * FROM rsc_booking")
//	public String getBooking();
	
	public String getBooking2();
	
	public int insertBooking(BookingVO vo);
//	public BookingVO getBooking(int rsc_id);
	
}
