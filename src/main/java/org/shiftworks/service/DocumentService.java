package org.shiftworks.service;

import java.util.List;

import org.shiftworks.domain.Criteria;
import org.shiftworks.domain.PageDTO;
import org.shiftworks.domain.PostVO;
import org.shiftworks.domain.ScrapDTO;
import org.shiftworks.domain.ScrapVO;

public interface DocumentService {
	
	public PageDTO getMyDocumentListWithPaging(Criteria cri);
	
	public PostVO getMyDocument(PostVO vo);
	
	public ScrapDTO getScrapListWithPaging(Criteria cri);
	
	public ScrapVO getScrap(ScrapVO vo);
	
	public PageDTO deptSelectList(Criteria cri);
	
	public PostVO deptSelect(PostVO vo);
	
	
}
