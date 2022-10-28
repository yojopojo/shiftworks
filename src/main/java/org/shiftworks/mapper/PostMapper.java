package org.shiftworks.mapper;

import java.util.List;

import org.shiftworks.domain.Criteria;
import org.shiftworks.domain.PostVO;

public interface PostMapper {
	
	public int insertPost(PostVO postvo);
	
<<<<<<< HEAD
	public List<PostVO> getListWithPaging(Criteria cri);
	
	public int updatePost(PostVO postvo);
	
	public int deletePost(int post_id);
	
	public PostVO getPost(int post_id);
=======
	//public List<PostVO> getListWithPaging(Criteria cri);
	
	public List<PostVO> getListWithPagingSearch(Criteria cri);
	
	public int updatePost(PostVO postvo);
	
	public int deletePost(int post_id);
	
	public PostVO getPost(int post_id);
	
	public int getTotal();
>>>>>>> branch 'feature-boa' of https://github.com/brightvvater/shiftworks.git

}
