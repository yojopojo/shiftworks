package org.shiftworks.service;

import java.util.List;

import org.shiftworks.domain.ReplyVO;

public interface ReplyService {
	
	public int insertReply(ReplyVO vo);
	
	public List<ReplyVO> getReply(int post_id);

}
