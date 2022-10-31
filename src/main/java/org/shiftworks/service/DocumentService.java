package org.shiftworks.service;

import java.util.List;

import org.shiftworks.domain.PostVO;
import org.shiftworks.domain.ScrapVO;

public interface DocumentService {
	
	public List<PostVO> getMyDocumentList(String emp_id);
	
	public PostVO getMyDocument(PostVO vo);
	
	public List<ScrapVO> getScrapList(String emp_id);
	
	public ScrapVO getScrap(ScrapVO vo);
	
	public List<PostVO> deptSelectList(String post_receivedept);
	
	public PostVO deptSelect(PostVO vo);
	
}
