package org.shiftworks.service;

import java.util.List;

import org.shiftworks.domain.ApprovalDTO;
import org.shiftworks.domain.ApprovalVO;
import org.shiftworks.domain.Criteria;
import org.shiftworks.domain.TempApprovalVO;

public interface ApprovalService {
	
	// 결재 
	public int insertForm(ApprovalVO approval);
	public ApprovalVO get(int apr_id);
//	public List<ApprovalDTO> getList();
	public List<ApprovalDTO> getList(Criteria cri);
	public boolean update(ApprovalVO approval);
	public void updateStatus(int apr_id, String status);
	
	
}
