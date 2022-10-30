package org.shiftworks.service;

import java.util.List;

import org.shiftworks.domain.Criteria;
import org.shiftworks.domain.PostVO;
import org.shiftworks.domain.ScrapVO;
import org.shiftworks.domain.Temp_BoardVO;
import org.shiftworks.mapper.PostMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class PostServiceImpl implements PostService {
	
	private PostMapper mapper;
	
	
	@Override
	public int insertPost(PostVO postvo) {
		return mapper.insertPost(postvo);
		
	}


	/*
	 * @Override public List<PostVO> getList(Criteria cri) { return
	 * mapper.getListWithPaging(cri); }
	 */
	
	@Override
	public List<PostVO> getListSearch(Criteria cri) {
		return mapper.getListWithPagingSearch(cri);
	}

	@Override
	public int updatePost(PostVO postvo) {
		return mapper.updatePost(postvo);
	}

	@Override
	public int deletePost(int post_id) {
		return mapper.deletePost(post_id);
	}

	@Override
	public PostVO getPost(int post_id) {
		return mapper.getPost(post_id);
	}

	@Override
	public int getTotal() {
		return mapper.getTotal();
	}


	@Override
	public int scrapPost(ScrapVO vo) {
		return mapper.scrapPost(vo);
	}


	@Override
	public int temporalPost(Temp_BoardVO vo) {
		return mapper.temporalPost(vo);
	}


	@Override
	public Temp_BoardVO temporalSelect(Temp_BoardVO vo) {
		return mapper.temporalSelect(vo);
	}

	

}
