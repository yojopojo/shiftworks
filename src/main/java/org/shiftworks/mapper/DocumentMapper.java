package org.shiftworks.mapper;

import java.util.List;

import org.shiftworks.domain.Dept_DocVO;
import org.shiftworks.domain.PostVO;
import org.shiftworks.domain.ScrapVO;

public interface DocumentMapper {
	
	public List<PostVO> getMyDocumentList(String emp_id);
	
	public PostVO getMyDocument(PostVO vo);
	
	public List<ScrapVO> getScrapList(String emp_id);
	
	public ScrapVO getScrap(ScrapVO vo);
	
	public List<Dept_DocVO> getDepartmentDocumentList(String dept_id);
	
	public Dept_DocVO getDepartmentDocument(Dept_DocVO vo);

}
