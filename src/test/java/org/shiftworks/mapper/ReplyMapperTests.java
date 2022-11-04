package org.shiftworks.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.shiftworks.domain.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {
	
	@Autowired
	private ReplyMapper mapper;
	
//	@Test
//	public void testInsert() {
//		ReplyVO vo = new ReplyVO();
//		vo.setPost_id(5);
//		vo.setR_writer("조현수");
//		vo.setR_content("댓글테스트");
//		
//		mapper.insertReply(vo);
//	}
	
	@Test
	public void testSelect() {
		
		int post_id = 2;
		List<ReplyVO>replies =  mapper.getReply(post_id);
		replies.forEach(reply -> log.info(reply));
	}

}
