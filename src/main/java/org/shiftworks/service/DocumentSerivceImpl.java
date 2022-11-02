package org.shiftworks.service;

import java.util.List;

import org.shiftworks.domain.Criteria;
import org.shiftworks.domain.PageDTO;
import org.shiftworks.domain.PostVO;
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

	@Override
	public PageDTO getMyDocumentListWithPaging(Criteria cri){
			List<PostVO>list = mapper.getListMyDocWithPagingSearch(cri);
			
			String emp_id ="U3948709"; //세션 변경
			PageDTO dto = new PageDTO(cri, mapper.getTotalMyDoc(emp_id), list);
			return dto;
	}

	@Override
	public PostVO getMyDocument(PostVO vo) {
		return mapper.getMyDocument(vo);
	}

	@Override
	public List<ScrapVO> getScrapList(String emp_id) {
		return mapper.getScrapList(emp_id);
	}

	@Override
	public ScrapVO getScrap(ScrapVO vo) {
		return mapper.getScrap(vo);
	}

	@Override
	public List<PostVO> deptSelectList(String post_receivedept) {
		return mapper.deptSelectList(post_receivedept);
	}

	@Override
	public PostVO deptSelect(PostVO vo) {
		return mapper.deptSelect(vo);
	}

	
	



}
