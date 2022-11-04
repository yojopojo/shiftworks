package org.shiftworks.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.shiftworks.domain.FileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class FileMapperTests {
	
	@Autowired
	private FileMapper mapper;
	
		
//	@Test
//	public void testInsertBoardFile() {
//		FileVO vo = new FileVO();
//		vo.setUuid("asdfasdf");
//		vo.setWork_id(101);
//		vo.setFile_name("test1");
//		vo.setFile_src("C://upload");
//		
//		mapper.insertBoardFile(vo);
//	}
	
//	@Test
//	public void testInsertTaskFile() {
//		FileVO vo = new FileVO();
//		vo.setUuid("dsds");
//		vo.setWork_id(4);
//		vo.setFile_name("teee");
//		vo.setFile_src("C://upload//a");
//		
//		mapper.insertTaskFile(vo);
//	}
	
//	@Test
//	public void testInsertApprovalFile() {
//		FileVO vo = new FileVO();
//		vo.setUuid("dsds");
//		vo.setWork_id(10);
//		vo.setFile_name("test3");
//		vo.setFile_src("C://upload//a");
//		
//		mapper.insertApprovalFile(vo);
//	}
	
//	@Test
//	public void testinsertChatRoomFile() {
//		FileVO vo = new FileVO();
//		vo.setUuid("dsds");
//		vo.setWork_id(5);
//		vo.setFile_name("test3");
//		vo.setFile_src("C://upload//a");
//		
//		mapper.insertChatRoomFile(vo);
//	}
	
	
	
//	@Test
//	public void testSelectBoardFile() {
//		
//		int post_id =101;
//		List<FileVO>list =  mapper.selectBoardFile(post_id);
//		list.forEach(file -> log.info(file));
//		
//	}
	
	
//	@Test
//	public void testSelectTask() {
//		int task_id = 4;
//		
//		mapper.selectTaskFile(task_id).forEach(file -> log.info(file));
//		
//	}
	
	
//	@Test
//	public void testSelectApprovalFile() {
//		
//		int apr_id = 10;
//		
//		mapper.selectApprovalFile(apr_id).forEach(file -> log.info(file));
//	}
	
//	@Test
//	public void testselectChatRoomFile() {
//		
//		int room_id = 5;
//		
//		mapper.selectChatRoomFile(room_id).forEach(file -> log.info(file));
//	}
	
//	@Test
//	public void testDeleteBoardFile() {
//		
//		String uuid ="asdfasdf";
//		int count = mapper.deleteBoardFile(uuid);
//		log.info("delete count:" + count);
//	}
	
//	@Test
//	public void testDeleteTaskFile() {
//		
//		String uuid ="dsds";
//		int count = mapper.deleteTaskFile(uuid);
//		log.info("delete count:" + count);
//	}
	
//	@Test
//	public void testDeleteApprovalFile() {
//		
//		String uuid ="dsds";
//		int count = mapper.deleteApprovalFile(uuid);
//		log.info("delete count:" + count);
//	}
	
	@Test
	public void testDeleteChatRoomFile() {
		
		String uuid ="dsds";
		int count = mapper.deleteChatRoomFile(uuid);
		log.info("delete count:" + count);
	}
	
	
	
}
