package org.shiftworks.service;

import java.util.List;

import org.shiftworks.domain.BoardCriteria;
import org.shiftworks.domain.HistoryVO;
import org.shiftworks.domain.BoardPageDTO;
import org.shiftworks.domain.PostVO;
import org.shiftworks.domain.ScrapVO;
import org.shiftworks.domain.Temp_BoardVO;

public interface PostService {
	
	public int insertPost(PostVO postvo);
	
	//public List<PostVO> getList(Criteria cri);
	
	public BoardPageDTO getListSearch(BoardCriteria cri);
	
	public int updatePost(PostVO postvo);
	
	public int deletePost(int post_id);
	
	public PostVO getPost(int post_id);
	
	public int getTotal();
	
	public int scrapPost(ScrapVO vo);
	
	public int temporalPost(Temp_BoardVO vo);
	
	public Temp_BoardVO temporalSelect(String emp_id);
	
	public int insertHistory(HistoryVO vo);
	
	public List<HistoryVO> selectHistory(String emp_id);

}