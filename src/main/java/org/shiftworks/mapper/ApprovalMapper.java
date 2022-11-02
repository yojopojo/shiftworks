package org.shiftworks.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.shiftworks.domain.ApprovalDTO;
import org.shiftworks.domain.ApprovalVO;
import org.shiftworks.domain.Criteria;
import org.shiftworks.domain.Temp_AprVO;

public interface ApprovalMapper {

	//public List<ApprovalVO> getList();
	public List<ApprovalVO> getListWithPaging(Criteria cri);
	public List<ApprovalVO> getReceivedListWithPaging(Criteria cri);
	public int insert(ApprovalVO approval);
	public ApprovalVO read(int apr_id);
	public int update(ApprovalVO approval);
	public void updateStatus(@Param("apr_id") int apr_id,@Param("status") String status);
	public int getTotal();
	public int temporalApr(Temp_AprVO vo);
	public Temp_AprVO temporalSelect(String emp_id);
}
