package org.shiftworks.service;

import java.util.List;

import org.shiftworks.domain.DocumentCriteria;
import org.shiftworks.domain.PageDTO;
import org.shiftworks.domain.PostVO;
import org.shiftworks.domain.ScrapDTO;
import org.shiftworks.domain.ScrapVO;

public interface DocumentService {
	
	public PageDTO getMyDocumentListWithPaging(DocumentCriteria cri);
	
	public PostVO getMyDocument(PostVO vo);
	
	public ScrapDTO getScrapListWithPaging(DocumentCriteria cri);
	
	public ScrapVO getScrap(ScrapVO vo);
	
	public PageDTO deptSelectList(DocumentCriteria cri);
	
	public PostVO deptSelect(PostVO vo);
	
	
}
