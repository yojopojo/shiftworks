package org.shiftworks.mapper;

import java.util.List;

import org.shiftworks.domain.ReplyVO;

public interface ReplyMapper {
	
	public int insertReply(ReplyVO vo);
	
	public List<ReplyVO> getReply(int post_id);

}
