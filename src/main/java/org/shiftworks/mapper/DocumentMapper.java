package org.shiftworks.mapper;

import java.util.List;

import org.shiftworks.domain.ApprovalCriteria;
import org.shiftworks.domain.ApprovalVO;
import org.shiftworks.domain.DocumentCriteria;
import org.shiftworks.domain.PostVO;
import org.shiftworks.domain.ScrapVO;

public interface DocumentMapper {
	
	public List<PostVO> getListMyDocWithPagingSearch(DocumentCriteria cri);
	
	public PostVO getMyDocument(PostVO vo);
	
	public List<ScrapVO> getScrapList(DocumentCriteria cri);
	
	public ScrapVO getScrap(ScrapVO vo);
	
	public List<PostVO> deptSelectList(DocumentCriteria cri);
	
	public PostVO deptSelect(PostVO vo);
	
	public List<ApprovalVO> approvalSelectList(ApprovalCriteria cri);
	
	public  ApprovalVO approvalSelect(ApprovalVO vo);
	
	public int getTotalMyDoc(String emp_id);
	
	public int getTotalScrap(String emp_id);
	
	public int getTotalDept(String post_receivedept);
	
	public int getTotalApproval();
	
	

}
