package org.shiftworks.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.shiftworks.domain.ReplyVO;
import org.shiftworks.mapper.ReplyMapperTests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyServiceTests {
	
	@Autowired
	private ReplyService service;

//	@Test
//	public void testInsert() {
//		ReplyVO vo = new ReplyVO();
//		
//		vo.setPost_id(2);
//		vo.setR_writer("홍길동");
//		vo.setR_content("서비스테스트");
//		int count = service.insertReply(vo);
//		log.info("count:" + count);
//	}
	
	@Test
	public void testSelect() {
		int post_id = 2;
		List<ReplyVO> replies =  service.getReply(post_id);
		replies.forEach(reply -> log.info(reply));
	}

}
