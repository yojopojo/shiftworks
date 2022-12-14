package org.shiftworks.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.shiftworks.domain.ApprovalDTO;
import org.shiftworks.domain.ApprovalVO;
import org.shiftworks.domain.ApprovalCriteria;
import org.shiftworks.domain.TempApprovalVO;


public interface ApprovalMapper {

	// 결재 문서 생성, 조회
	//public List<ApprovalVO> getList();
	public List<ApprovalVO> getListWithPaging(ApprovalCriteria cri);
	public List<ApprovalVO> getReceivedListWithPaging(ApprovalCriteria cri);
	public int getTotal(String emp_id);
	int getReceivedTotal(String emp_id);
	public int insert(ApprovalVO approval);
	public ApprovalVO read(int apr_id);
	
	// 결재 상태 변경
	public int update(ApprovalVO approval);
	public void updateStatus(@Param("apr_id") int apr_id, @Param("status") String status);
	
	// 임시저장 구현
	public void temporalApr(TempApprovalVO vo);
	public String getDept(String emp_id);
	public List<TempApprovalVO> tempList(String emp_id);
	public TempApprovalVO tempSelect(int temp_id);
	public void deleteTemp(int temp_id);
//	public TempApprovalVO temporalSelect(String emp_id);
}
