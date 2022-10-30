package org.shiftworks.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.shiftworks.domain.ApprovalVO;

public interface ApprovalMapper {

	public List<ApprovalVO> getList();
	public int insert(ApprovalVO approval);
	public ApprovalVO read(int apr_id);
	public int update(ApprovalVO approval);
	public void updateStatus(@Param("apr_id") int apr_id,@Param("status") String status);
}
