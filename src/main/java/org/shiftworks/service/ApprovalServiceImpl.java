package org.shiftworks.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.shiftworks.domain.ApprovalDTO;
import org.shiftworks.domain.ApprovalVO;
import org.shiftworks.domain.ApprovalCriteria;
import org.shiftworks.domain.TempApprovalVO;
import org.shiftworks.mapper.ApprovalMapper;
import org.shiftworks.mapper.FileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class ApprovalServiceImpl implements ApprovalService {
	
	@Autowired
	private ApprovalMapper mapper;
	
	@Autowired
	private FileMapper filemapper;

	@Override
	@Transactional
	public int insertForm(ApprovalVO approval) {
		
		/*
		 * boolean result = mapper.insert(approval) == 1;
		 * 
		 * // 업로드된 파일이 없을 경우 메소드 종료 if (approval.getFileList() == null ||
		 * approval.getFileList().size() <= 0) { return mapper.insert(approval); }
		 * 
		 * approval.getFileList().forEach(file -> { filemapper.insertApprovalFile(file);
		 * });
		 */
		return mapper.insert(approval);
	}

	@Override
	public ApprovalDTO get(int apr_id) {
		return toDto(mapper.read(apr_id));
	}

	@Override
	public List<ApprovalDTO> getList(ApprovalCriteria cri) {
//		List<ApprovalVO> list = mapper.getListWithPaging(cri);
//		List<ApprovalDTO> dtos = new ArrayList<ApprovalDTO>();
//		
//		// 결재 상태, 결재 양식 String으로 변환
//		for (ApprovalVO approval : list) {
//			
//			dtos.add(toDto(approval));
//			
//			
//		}	
//		return dtos;
		
		return mapper.getListWithPaging(cri).stream()
				// 위 향상된 for문과 동일
					.map(a -> toDto(a)).collect(Collectors.toList()); // a(변수명) = ApprovalVO
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

	
	private ApprovalDTO toDto(ApprovalVO approval) {
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
		return ApprovalDTO.builder()
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
	}
	

	/*
	 * 결재할 문서함
	 */	
	@Override
	public List<ApprovalDTO> getReceivedList(ApprovalCriteria cri) {
		
		return mapper.getReceivedListWithPaging(cri).stream()
				.map(a -> toDto(a)).collect(Collectors.toList()); // a = ApprovalVO
	}
	
	
	 /* * * * * * * * * * * * * * * * * * *
			임시저장 구현
	 * * * * * * * * * * * * * * * * * * */	

		/*
		 임시저장
		*/
		@Override
		public void temporalApr(TempApprovalVO vo) {
			vo.setDept_id(mapper.getDept(vo.getEmp_id()));
			mapper.temporalApr(vo);
		}
	
		@Override
		public List<TempApprovalVO> tempList(String emp_id) {
			
			return mapper.tempList(emp_id);
		}
	
		@Override
		@Transactional
		public TempApprovalVO tempSelect(int temp_id) {
			//log.info("temp_id : " + temp_id);
			
			TempApprovalVO temp = mapper.tempSelect(temp_id);
			
			mapper.deleteTemp(temp_id);
			
			return temp;
		}

		@Override
		public int getReceivedTotal() {
			// TODO Auto-generated method stub
			return mapper.getReceivedTotal();
		}

		
	
		/*
		임시저장
		*/
	//	@Override
	//	public TempApprovalVO temporalSelect(String emp_id) { 
	//		return mapper.temporalSelect(emp_id);
	//	}
		
		
	
		
	
		
		

}
