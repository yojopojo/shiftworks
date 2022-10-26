package org.shiftworks.mapper;

import java.util.List;


import org.shiftworks.domain.ApprovalVO;

public interface ApprovalMapper {

	public List<ApprovalVO> getList();
	public void insert(ApprovalVO approval);
	public ApprovalVO read(int apr_id);
	public int update(ApprovalVO approval);
	
}
