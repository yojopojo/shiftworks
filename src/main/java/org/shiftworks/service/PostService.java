package org.shiftworks.service;

import java.util.List;

import org.shiftworks.domain.Criteria;
import org.shiftworks.domain.PostVO;

public interface PostService {
	
	public int insertPost(PostVO postvo);
	
<<<<<<< HEAD
	public List<PostVO> getList(Criteria cri);
	
	public int updatePost(PostVO postvo);
	
	public int deletePost(int post_id);
	
	public PostVO getPost(int post_id);
=======
	//public List<PostVO> getList(Criteria cri);
	
	public List<PostVO> getListSearch(Criteria cri);
	
	public int updatePost(PostVO postvo);
	
	public int deletePost(int post_id);
	
	public PostVO getPost(int post_id);
	
	public int getTotal();
>>>>>>> branch 'feature-boa' of https://github.com/brightvvater/shiftworks.git

}
