package org.shiftworks.service;

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
		
		return vo;
	}

	@Override
	public List<BookingVO> getList() {
		log.info("getList Service.....................");
		List<BookingVO> list = mapper.getList();
		log.info(list);
		
		return list;
	}

}
