package org.shiftworks.mapper;

import java.util.List;

import org.shiftworks.domain.Criteria;
import org.shiftworks.domain.HistoryVO;
import org.shiftworks.domain.PostVO;
import org.shiftworks.domain.ScrapVO;
import org.shiftworks.domain.Temp_BoardVO;

public interface PostMapper {
	
	public int insertPost(PostVO postvo);
	
	//public List<PostVO> getListWithPaging(Criteria cri);
	
	public List<PostVO> getListWithPagingSearch(Criteria cri);
	
	public int updatePost(PostVO postvo);
	
	public int deletePost(int post_id);
	
	public PostVO getPost(int post_id);
	
	public int getTotal();
	
	public int scrapPost(ScrapVO vo);
	
	public int temporalPost(Temp_BoardVO vo);
	
	public Temp_BoardVO temporalSelect(Temp_BoardVO vo);
	
	public int insertHistory(HistoryVO vo);
	
	

}
