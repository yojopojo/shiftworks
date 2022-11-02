package org.shiftworks.mapper;

import java.util.List;

import org.shiftworks.domain.Criteria;
import org.shiftworks.domain.PostVO;
import org.shiftworks.domain.ScrapVO;

public interface DocumentMapper {
	
	public List<PostVO> getListMyDocWithPagingSearch(Criteria cri);
	
	public PostVO getMyDocument(PostVO vo);
	
	public List<ScrapVO> getScrapList(Criteria cri);
	
	public ScrapVO getScrap(ScrapVO vo);
	
	public List<PostVO> deptSelectList(Criteria cri);
	
	public PostVO deptSelect(PostVO vo);
	
	public int getTotalMyDoc(String emp_id);
	
	public int getTotalScrap(String emp_id);
	
	public int getTotalDept(String post_receivedept);

}
