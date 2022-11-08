package org.shiftworks.service;

import java.util.List;

import org.shiftworks.domain.ApprovalDTO;
import org.shiftworks.domain.ApprovalVO;
import org.shiftworks.domain.ApprovalCriteria;
import org.shiftworks.domain.TempApprovalVO;


public interface ApprovalService {
	
	// 결재 문서 생성, 조회
//	public List<ApprovalDTO> getList();
	public int insertForm(ApprovalVO approval);
	public ApprovalDTO get(int apr_id);
	public List<ApprovalDTO> getList(ApprovalCriteria cri);
	public int getTotal();
	public int getReceivedTotal();
	public List<ApprovalDTO> getReceivedList(ApprovalCriteria cri);
	
	// 결재 상태 변경
	public boolean update(ApprovalVO approval);
	public void updateStatus(int apr_id, String status);
	
	// 임시저장 구현
	public void temporalApr(TempApprovalVO vo);
	public List<TempApprovalVO> tempList(String emp_id);
	public TempApprovalVO tempSelect(int temp_id);
//	public TempApprovalVO temporalSelect(String emp_id);
	
	// 파일업로드
	

	
	
}
