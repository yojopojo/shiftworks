package org.shiftworks.service;

import java.util.List;

import org.shiftworks.domain.DocumentCriteria;
import org.shiftworks.domain.PageDTO;
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
	public PageDTO getMyDocumentListWithPaging(DocumentCriteria cri){
			List<PostVO>list = mapper.getListMyDocWithPagingSearch(cri);
			
			String emp_id =cri.getEmp_id();
			PageDTO dto = new PageDTO(cri, mapper.getTotalMyDoc(emp_id), list);
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
	public PageDTO deptSelectList(DocumentCriteria cri) {
		List<PostVO>list = mapper.deptSelectList(cri);
		
		String post_receivedept = "12";
		PageDTO dto = new PageDTO(cri, mapper.getTotalDept(post_receivedept), list);
		return dto;
	}
	
	//부서수신함 상세
	@Override
	public PostVO deptSelect(PostVO vo) {
	
		return mapper.deptSelect(vo);
	}

	
	



}
