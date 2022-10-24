package org.shiftworks.service;

import java.util.List;

import org.shiftworks.domain.PostVO;

public interface PostService {
	
	public int insertPost(PostVO postvo);
	
	public List<PostVO> getList();
	
	public int updatePost(PostVO postvo);
	
	public int deletePost(int post_id);
	
	public PostVO getPost(int post_id);

}
