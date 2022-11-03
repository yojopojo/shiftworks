package org.shiftworks.mapper;

import java.util.List;

import org.shiftworks.domain.FileVO;

public interface FileMapper {

	
	public int insertBoardFile(FileVO vo);
	
	public int insertTaskFile(FileVO vo);
	
	public int insertApprovalFile(FileVO vo);
	
	public int insertChatRoomFile(FileVO vo);
	
	public List<FileVO> selectBoardFile(int post_id);
	
	public List<FileVO> selectTaskFile(int task_id);
	
	public List<FileVO> selectApprovalFile(int apr_id);
	
	public List<FileVO> selectChatRoomFile(int room_id);
	
	public int deleteBoardFile(String uuid);
	
	public int deleteTaskFile(String uuid);

	public int deleteApprovalFile(String uuid);
	
	public int deleteChatRoomFile(String uuid);
	
}
