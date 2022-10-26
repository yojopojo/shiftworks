package org.shiftworks.service;

import java.util.List;

import org.shiftworks.domain.ApprovalVO;
import org.shiftworks.domain.TempApprovalVO;

public interface ApprovalService {
	
	public int insertForm(ApprovalVO approval);
	public ApprovalVO get(int apr_id);
	public List<ApprovalVO> getList();
	public boolean update(ApprovalVO approval);

}
