package org.shiftworks.service;

import java.util.List;

import org.shiftworks.domain.ApprovalVO;
import org.shiftworks.domain.TempApprovalVO;

public interface ApprovalService {
	
	public String getForm();
	public int insertForm(ApprovalVO approval);
	public ApprovalVO getTemporal(int apr_id);
	public int insertTemporal(TempApprovalVO temp);
	public TempApprovalVO insertTemporal(Integer temp_id);
	public int updateTemporal(TempApprovalVO temp);
	public List<ApprovalVO> getCheckStatus(ApprovalVO approval);
	public List<ApprovalVO> getReceiveApprovalList(ApprovalVO approval);
	public int updateApprovalStatus(ApprovalVO approval);
	public List<ApprovalVO> getRejectApprovalList();
	public List<ApprovalVO> getSignedApprovalList();
	public String getApprovalLine(int posiotion_id);
	public String getApprovalForm();
	

}
