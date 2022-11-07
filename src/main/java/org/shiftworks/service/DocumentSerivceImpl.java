package org.shiftworks.service;

import java.util.List;

import org.shiftworks.domain.DocumentCriteria;
import org.shiftworks.domain.DocumentPageDTO;
import org.shiftworks.domain.ApprovalCriteria;
import org.shiftworks.domain.ApprovalDTO;
import org.shiftworks.domain.ApprovalListDTO;
import org.shiftworks.domain.ApprovalPageDTO;
import org.shiftworks.domain.ApprovalVO;
import org.shiftworks.domain.BoardPageDTO;
import org.shiftworks.domain.PostVO;
import org.shiftworks.domain.ScrapDTO;
import org.shiftworks.domain.ScrapVO;
import org.shiftworks.mapper.DocumentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class DocumentSerivceImpl implements DocumentService {
	
	private DocumentMapper mapper;
	
	//내 게시물
	@Override
	public DocumentPageDTO getMyDocumentListWithPaging(DocumentCriteria cri){
			List<PostVO>list = mapper.getListMyDocWithPagingSearch(cri);
			
			String emp_id =cri.getEmp_id();
			DocumentPageDTO dto = new DocumentPageDTO(cri, mapper.getTotalMyDoc(emp_id), list);
			return dto;
	}
	
	//내 게시물 상세
	@Override
	public PostVO getMyDocument(PostVO vo) {
		return mapper.getMyDocument(vo);
	}
	
	//스크랩
	@Override
	public ScrapDTO getScrapListWithPaging(DocumentCriteria cri) {
		List<ScrapVO>list = mapper.getScrapList(cri);
		
		String emp_id = cri.getEmp_id();
		ScrapDTO dto = new ScrapDTO(cri, mapper.getTotalScrap(emp_id), list);
		return dto;
	}
	
	//스크랩상세
	@Override
	public ScrapVO getScrap(ScrapVO vo) {
		return mapper.getScrap(vo);
	}

	//부서수신함
	@Override
	public DocumentPageDTO deptSelectList(DocumentCriteria cri) {
		List<PostVO>list = mapper.deptSelectList(cri);
		
		String post_receivedept =  mapper.getDept(cri.getEmp_id()); //해당 사원의 부서 찾기
		DocumentPageDTO dto = new DocumentPageDTO(cri, mapper.getTotalDept(post_receivedept), list);
		return dto;
	}
	
	//부서수신함 상세
	@Override
	public PostVO deptSelect(PostVO vo) {
	
		return mapper.deptSelect(vo);
	}

	@Override
	public ApprovalListDTO approvalSelectList(ApprovalCriteria cri) {
		List<ApprovalVO>list = mapper.approvalSelectList(cri);
		
		String emp_id = cri.getEmp_id();
		ApprovalListDTO dto = new ApprovalListDTO(cri, mapper.getTotalApproval(), list);
		return dto;
	}

	@Override
	public ApprovalVO approvalSelect(ApprovalVO vo) {
		return mapper.approvalSelect(vo);
	}

	@Override
	public String getDept(String emp_id) {
		 return mapper.getDept(emp_id);
	}

	
	



}
