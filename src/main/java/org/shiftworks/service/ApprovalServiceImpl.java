package org.shiftworks.service;

import java.util.List;

import org.shiftworks.domain.ApprovalVO;
import org.shiftworks.domain.TempApprovalVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class ApprovalServiceImpl implements ApprovalService {
	
	@Autowired
	private ApprovalVO approval;
	private TempApprovalVO temp;

	@Override
	public String getForm() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertForm(ApprovalVO approval) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ApprovalVO getTemporal(int apr_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertTemporal(TempApprovalVO temp) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TempApprovalVO insertTemporal(Integer temp_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateTemporal(TempApprovalVO temp) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ApprovalVO> getCheckStatus(ApprovalVO approval) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ApprovalVO> getReceiveApprovalList(ApprovalVO approval) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateApprovalStatus(ApprovalVO approval) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ApprovalVO> getRejectApprovalList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ApprovalVO> getSignedApprovalList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getApprovalLine(int posiotion_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getApprovalForm() {
		// TODO Auto-generated method stub
		return null;
	}

}
