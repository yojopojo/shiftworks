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
	public List<ApprovalDTO> getReceivedList(Criteria cri);
	public boolean update(ApprovalVO approval);
	public void updateStatus(int apr_id, String status);
	public int getTotal();
	public void temporalApr(TempApprovalVO vo);
	public List<TempApprovalVO> tempList(String emp_id);
	public TempApprovalVO tempSelect(int temp_id);
//	public TempApprovalVO temporalSelect(String emp_id);
	
}
