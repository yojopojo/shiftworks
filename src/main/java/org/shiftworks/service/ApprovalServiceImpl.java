package org.shiftworks.service;

import java.util.List;

import org.shiftworks.domain.ApprovalVO;
import org.shiftworks.mapper.ApprovalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class ApprovalServiceImpl implements ApprovalService {
	
	@Autowired
	private ApprovalMapper mapper;

	@Override
	public int insertForm(ApprovalVO approval) {
		return mapper.insert(approval);
	}

	@Override
	public ApprovalVO get(int apr_id) {
		return mapper.read(apr_id);
	}

	@Override
	public List<ApprovalVO> getList() {
		return mapper.getList();
	}

	@Override
	public boolean update(ApprovalVO approval) {
		return mapper.update(approval) == 1;
	}

	@Override
	public void updateStatus(int apr_id, String status) {
		
		mapper.updateStatus(apr_id, status);
	}

	

}
