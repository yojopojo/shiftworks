package org.shiftworks.service;

import java.util.List;

import org.shiftworks.domain.Dept_DocVO;
import org.shiftworks.domain.PostVO;
import org.shiftworks.domain.ScrapVO;
import org.shiftworks.mapper.DocumentMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class DocumentSerivceImpl implements DocumentService {
	
	private DocumentMapper mapper;

	@Override
	public List<PostVO> getMyDocumentList(String emp_id) {
		return mapper.getMyDocumentList(emp_id);
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
	public List<Dept_DocVO> getDepartmentDocumentList(String dept_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dept_DocVO getDepartmentDocument(Dept_DocVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
