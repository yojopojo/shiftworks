package org.shiftworks.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.shiftworks.domain.ApprovalDTO;
import org.shiftworks.domain.ApprovalVO;
import org.shiftworks.domain.Criteria;
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
	public List<ApprovalDTO> getList(Criteria cri) {
		List<ApprovalVO> list = mapper.getListWithPaging(cri);
		List<ApprovalDTO> dtos = new ArrayList<ApprovalDTO>();
		
		// 결재 상태, 결재 양식 String으로 변환
		for (ApprovalVO approval : list) {
			
			String status = "";			
			if (approval.getApr_status() == '0') {
				status = "대기중";
			} else if (approval.getApr_status()=='1') {
				status = "승인";
			} else if (approval.getApr_status()=='2'){
				status = "반려";
			} else {
				status = "완료";
			}
			
			String af_id = "";
			if (approval.getAf_id()== 1) {
				af_id = "기안서";
			} else if (approval.getAf_id()== 2) {
				af_id = "품의서";
			} else if (approval.getAf_id()== 3) {
				af_id = "휴가신청서";
		}
			
			// builder 패턴 이용 
			ApprovalDTO dto = ApprovalDTO.builder()
			.apr_id(approval.getApr_id())
			.af_id(af_id) // 위에서 변환했기 때문에 approval에서 가져올 필요 없음
			.emp_id(approval.getEmp_id())
			.apr_receivedate(approval.getApr_receivedate())
			.apr_title(approval.getApr_title())
			.apr_content(approval.getApr_content())
			.apr_status(status) // 위에서 변환했기 때문에 approval에서 가져올 필요 없음
			.apr_comment(approval.getApr_comment())
			.apr_signdate(approval.getApr_signdate())
			
			.build();	
			dtos.add(dto); 
		}				
		return dtos;
	}

	@Override
	public boolean update(ApprovalVO approval) {
		return mapper.update(approval) == 1;
	}

	@Override
	public void updateStatus(int apr_id, String status) {
		
		mapper.updateStatus(apr_id, status);
	}

	@Override
	public int getTotal() {
		return mapper.getTotal();
	}

//	@Override
//	public List<ApprovalDTO> getList(Criteria cri) {
//		
//		return mapper.getListWithPaging(cri);
//	}

	

	
	

}
