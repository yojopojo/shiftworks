package org.shiftworks.mapper;

import java.util.List;

import org.shiftworks.domain.BookingVO;
import org.shiftworks.domain.BookingCriteria;

public interface BookingMapper {
	
//	@Select("SELECT * FROM rsc_booking")
//	public String getBooking();
	
	public String getBooking2();
	
	//예약하기
	public int insertBooking(BookingVO vo);
	//예약목록불러오기(예약 중복 조건 비교)
	public List<BookingVO> getBookingList(BookingVO vo);
	
	//예약 상세보기(1개)
	public BookingVO getBooking(int book_id);
	//예약 목록 리스트
	public List<BookingVO> getList();
	//예약 목록 리스트(페이징)
	public List<BookingVO> getListwithPaging(BookingCriteria cri);
	//전체 예약 숫자 구하기
	public int getTotalCount(BookingCriteria cri);
	
	
	//내 예약목록 보기
	public List<BookingVO> getMyList(String emp_id);
	public int deleteBooking(int book_id);
	
}
