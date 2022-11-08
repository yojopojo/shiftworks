package org.shiftworks.controller;


import java.io.File;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.annotations.Delete;
import org.shiftworks.domain.BoardCriteria;
import org.shiftworks.domain.HistoryVO;
import org.shiftworks.domain.BoardPageDTO;
import org.shiftworks.domain.BoardVO;
import org.shiftworks.domain.EmployeeVO;
import org.shiftworks.domain.FileVO;
import org.shiftworks.domain.PostVO;
import org.shiftworks.domain.ScrapVO;
import org.shiftworks.domain.Temp_BoardVO;
import org.shiftworks.mapper.FileMapper;
import org.shiftworks.service.PostService;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import oracle.net.aso.l;

@RequestMapping("/board/*")
@RestController
@Log4j
@AllArgsConstructor
public class PostController {
	
	
	private PostService service;
	
	private FileMapper mapper;
	
	//register form 이동
	@GetMapping(value = "/new")
	@PreAuthorize("isAuthenticated()")
	public ModelAndView register() throws Exception{
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/board/BOA_register");
		return mav;
	}
	
	//register form에서 받아온 값 db에 넣기
	@PostMapping(value = "/new")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<String> register(@RequestBody PostVO vo){
		//log.info("register......");
		
		//파일업로드확인 
		if(vo.getFileList() !=null) {
			vo.getFileList().forEach(file -> log.info(file));
		}
		
	
		int insertCount = service.insertPost(vo);
		
		return insertCount ==1
		? new ResponseEntity<String>("success", HttpStatus.OK)
		: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//파일 업로드
	@PostMapping(value = "/uploadAjaxAction", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<FileVO>> uploadAjaxPost(MultipartFile[] uploadFile) {
	
		//log.info("update ajax post.........");
		
		
		List<FileVO> list = new ArrayList<FileVO>();
	
		String uploadFolder = "C:\\upload";
	
		for (MultipartFile multipartFile : uploadFile) {
	
			//log.info("-------------------------------------");
			//log.info("Upload File Name: " + multipartFile.getOriginalFilename());
			//log.info("Upload File Size: " + multipartFile.getSize());
			
			FileVO vo = new FileVO();
			
			UUID uuid = UUID.randomUUID();
			vo.setUuid(uuid.toString());
	
			String uploadFileName = multipartFile.getOriginalFilename();
			vo.setFile_name(uploadFileName);
						
			// uuid + 실제 파일명
			uploadFileName = uuid.toString() + "_" + uploadFileName;
	
			try {
				// 파일 객체 생성
				File saveFile = new File(uploadFolder, uploadFileName);
				multipartFile.transferTo(saveFile);
				list.add(vo);
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}
		
		return new ResponseEntity<List<FileVO>>(list, HttpStatus.OK);
	}
	
	
		
	
		//게시판 번호에 맞는 리스트 호출
		@GetMapping(value = "/list")
		@PreAuthorize("isAuthenticated()")
		public ModelAndView getList(BoardCriteria cri, Authentication auth) {
			
			//log.info("getList..........");
			ModelAndView mav = new ModelAndView();
			
			
			mav.setViewName("/board/BOA_list");
			
			mav.addObject("pageMaker", service.getListSearch(cri));
		
			return mav;
		}

	
	//js에 리스트 전달해주기 
	@GetMapping(value = "/listEntity/{pageNum}/{type}/{keyword}")
	public ResponseEntity<BoardPageDTO> getListEntity(@PathVariable("pageNum")int pageNum,
																			@PathVariable("type") String type,
																			@PathVariable("keyword") String keyword){
		
		BoardCriteria cri = new BoardCriteria();
		cri.setPageNum(pageNum);
		if(!type.equals("1")) {
			cri.setType(type);
		}
		if(!keyword.equals("1")) {
			cri.setKeyword(keyword);
		}
		
		//log.info("getListEntity......");
		
		return new ResponseEntity<BoardPageDTO>(service.getListSearch(cri),HttpStatus.OK);
		
	}
	
	
	//글번호 클릭 시 BOA_get.jsp로 이동
	@GetMapping(value = "/get")
	@PreAuthorize("isAuthenticated()")
	public ModelAndView getPost(@RequestParam("post_id") int post_id, 
												@ModelAttribute("cri") BoardCriteria cri) throws Exception{
		//log.info("get.........");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/board/BOA_get");
		mav.addObject("post", service.getPost(post_id));
		return mav;
	}
	
	

	
	//수정 클릭 시 BOA_modify.jsp로 이동
	@GetMapping(value = "/modify")
	@PreAuthorize("isAuthenticated()")
		public ModelAndView modify(@RequestParam("post_id") int post_id, 
								  					@ModelAttribute("cri") BoardCriteria cri) throws Exception{
			//log.info("modify.........");
			ModelAndView mav = new ModelAndView();
			mav.setViewName("/board/BOA_modify");
			mav.addObject("post", service.getPost(post_id));
			return mav;
		}
	
	// 수정 데이터 값을 db 넣기
	@PostMapping(value = "/modify")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<String> modify(@RequestBody PostVO post){
		
		//log.info("modify..................");
		return service.updatePost(post)==1
		? new ResponseEntity<String>("success",HttpStatus.OK)
		: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	//삭제하기
	@DeleteMapping(value = "/{post_id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<String> deletePost(@PathVariable("post_id")int post_id){
		
		 return service.deletePost(post_id) ==1
		? new ResponseEntity<String>("success", HttpStatus.OK)
		: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	// 파일 다운로드
	@GetMapping(value="/download",
				// 다운로드가 가능하도록 MIME 타입 지정
				produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<Resource> downloadFile(String fileName) {
				
		FileSystemResource resource = new FileSystemResource("C:\\upload\\" + fileName);

		// 다운로드 요청한 파일이 없는 경우
		if(resource.exists() == false) {
			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		}
				
		String resourceName = resource.getFilename();
		// C:\\upload에 저장된 파일명에서 uuid 제거
		String resourceOriginalName = resourceName.substring(resourceName.indexOf("_") + 1);
				
		HttpHeaders headers = new HttpHeaders();
				
		try {
			// 파일 다운로드 시 사용할 이름
			String downloadName = new String(resourceOriginalName.getBytes("UTF-8"), "ISO-8859-1");
					
			headers.add("Content-Disposition", "attachment; filename=" + downloadName);
					
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}
		
		
	//파일 삭제
	@DeleteMapping("/deleteFile")
	public ResponseEntity<String> deleteFile(@RequestParam FileVO vo) {
		File file;
			
		//log.info(vo.getFile_name());
		//log.info(vo.getUuid());
		try {
		// 삭제 대상을 파일 객체로 만듦
		file = new File("C:\\upload\\" + URLDecoder.decode(vo.getFile_name(), "UTF-8"));
				
		// 실제 파일 삭제
		file.delete();
				
	} catch (Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}
			
	return new ResponseEntity<String>("success", HttpStatus.OK);
			
	}
	
	//스크랩하기
	@PostMapping(value="/scrap")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<String> scrapPost(@RequestBody ScrapVO vo, Authentication auth){
		//log.info("scrap..........");
		
		//로그인한 사람의 emp_id 구하기
		UserDetails ud = (UserDetails)auth.getPrincipal();
		//log.info(ud.getUsername());
		String emp_id = ud.getUsername();
		vo.setEmp_id(emp_id);
		
		String str = vo.getPost_regdate();
		String[] regdate = str.split(" ");
		//log.info(regdate[0]);
		vo.setPost_regdate(regdate[0]);
		
		return service.scrapPost(vo)==1
		? new ResponseEntity<String>("success", HttpStatus.OK)
		: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	//임시저장/업데이트하기 
	@PostMapping(value = "/temporal")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<String> temporalPost(@RequestBody Temp_BoardVO vo){
		//log.info("temporal......");
		
		return service.temporalPost(vo)==1
		? new ResponseEntity<String>("success",HttpStatus.OK)
		: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	//임시저장 불러오기 
	@GetMapping(value = "/temporal")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Temp_BoardVO> temporalSelect(Authentication auth){
		//log.info("temporalSelect.....");
		
		//로그인한 사람의 emp_id 구하기
		UserDetails ud = (UserDetails)auth.getPrincipal();
		//log.info(ud.getUsername());
		String emp_id = ud.getUsername();
		
		
		return new ResponseEntity<Temp_BoardVO>(service.temporalSelect(emp_id),HttpStatus.OK);
	}
	
	
	
		//임시저장 뷰
		@GetMapping(value = "/temporalview")
		public ModelAndView temporalview(Authentication auth){
			//log.info("temporalSelect.....");
			
			//로그인한 사람의 emp_id 구하기
			UserDetails ud = (UserDetails)auth.getPrincipal();
			//log.info(ud.getUsername());
			String emp_id = ud.getUsername();

			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("/board/BOA_register");
			mav.addObject("post", service.temporalSelect(emp_id));
			return mav;
		}
	
	
	//게시글 클릭 시 history 테이블에 추가하기
	@PostMapping(value = "/history/{post_id}")
	public ResponseEntity<String> insertHistory(@PathVariable("post_id") int post_id, Authentication auth){
		
		//log.info("history.......");
		
		//로그인한 사람의 emp_id 구하기
		UserDetails ud = (UserDetails)auth.getPrincipal();
		//log.info(ud.getUsername());
		String emp_id = ud.getUsername();
		String dept_id = service.getDeptId(emp_id);
		
		HistoryVO vo = new HistoryVO();
		vo.setEmp_id(emp_id);
		vo.setDept_id(dept_id);
		vo.setPost_id(post_id); 
		
		return service.insertHistory(vo)==1
		?new ResponseEntity<String>("success", HttpStatus.OK)
		: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	//history불러오기
		@GetMapping(value = "/history")
		public ResponseEntity<List<HistoryVO>> getHistory(Authentication auth){
			
			//log.info("gethistory.......");
			
			//로그인한 사람의 emp_id 구하기
			UserDetails ud = (UserDetails)auth.getPrincipal();
			//log.info(ud.getUsername());
			String emp_id = ud.getUsername();
			
			return new ResponseEntity<List<HistoryVO>>(service.selectHistory(emp_id),HttpStatus.OK);
		}
	
	//이전글 불러오기
	@GetMapping(value = "/selectPrev/{post_id}", produces = "application/json; charset=UTF-8")
	public ResponseEntity<PostVO> selectPrev(@PathVariable("post_id") int post_id){
		
		//log.info("selectPrev........");
		
		return new ResponseEntity<PostVO>(service.selectPrev(post_id),HttpStatus.OK);
	}
	
	//다음글 불러오기
	@GetMapping(value = "/selectNext/{post_id}", produces = "application/json; charset=UTF-8")
	public ResponseEntity<PostVO> selectNext(@PathVariable("post_id") int post_id){
			
		//log.info("selectNext........");
		
		
		return new ResponseEntity<PostVO>(service.selectNext(post_id),HttpStatus.OK);
	}
	
	//새 게시판 만드는 페이지 이동
	@GetMapping(value = "/newboard")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ModelAndView newBoard() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/BOA_newboard");
		return mav;
	}
	
	//새 게시판 생성 시 db에 삽입
	@PostMapping(value = "/newBoard")
	public ResponseEntity<String> insertNewBoard(@RequestBody BoardVO vo){
		
		//log.info("new Board.........");
		
		return service.insertNewBoard(vo)==1
		? new ResponseEntity<String>("success",HttpStatus.OK)
		: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	//공개게시판 목록 불러오기
	@GetMapping(value = "/boardList")
	public ResponseEntity<List<BoardVO>> selectBoardList(){
		
		//log.info("boardList.......");
		return new ResponseEntity<List<BoardVO>>(service.selectBoardList(),HttpStatus.OK);
	}
	
	
	//게시판 관리 페이지 이동
	@GetMapping(value = "/boardmanage")
	public ModelAndView boardManage(){
				
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/board/BOA_boardmanage");
				
		return mav;
	}
	
	
	//게시판 목록 불러오기
	@GetMapping(value = "/allBoardList")
	public ResponseEntity<List<BoardVO>> allBoardList(){
			
		//log.info("allboardList.......");
			
		return new ResponseEntity<List<BoardVO>>(service.allBoardList(),HttpStatus.OK);
	}
		
		
	//게시판 삭제하기
	@DeleteMapping(value = "/deleteBoard/{b_id}")
	public ResponseEntity<String> deleteBoard(@PathVariable("b_id") int b_id){
		
		return service.deleteBoard(b_id) ==1
		? new ResponseEntity<String>("success", HttpStatus.OK)
		: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
