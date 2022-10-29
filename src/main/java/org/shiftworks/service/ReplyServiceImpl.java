package org.shiftworks.service;

import java.util.List;

import org.shiftworks.domain.ReplyVO;
import org.shiftworks.mapper.PostMapper;
import org.shiftworks.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class ReplyServiceImpl implements ReplyService {
	
	
	private ReplyMapper mapper;

	@Override
	public int insertReply(ReplyVO vo) {
		return mapper.insertReply(vo);
	}

	@Override
	public List<ReplyVO> getReply(int post_id) {
		return mapper.getReply(post_id);
	}

}
