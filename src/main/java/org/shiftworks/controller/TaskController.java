package org.shiftworks.controller;

import java.io.File;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.shiftworks.domain.FileVO;
import org.shiftworks.domain.TaskCriteria;
import org.shiftworks.domain.TaskVO;
import org.shiftworks.mapper.FileMapper;
import org.shiftworks.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("/task/*")
@AllArgsConstructor
public class TaskController {

	@Autowired
	private TaskService service;
	
	@Autowired
	private FileMapper mapper;
	
	@GetMapping(value="/main")
	public ModelAndView main() {
		
		ModelAndView mav = new ModelAndView("/task/TSK_list");

		return mav;
		
	}
	
	// 검색기능 적용 페이징 처리
	@GetMapping(value="/pages/{dept_id}/{type}/{keyword}/{pageNum}")
	public ModelAndView getList(
			@PathVariable String dept_id, @PathVariable String type,
			@PathVariable String keyword, @PathVariable Integer pageNum) {
		
		log.info("Controller: getList.........");

		// 출력 페이지
		ModelAndView mav = new ModelAndView("/task/TSK_list");
		
		// 검색 조건 없을 경우 null 대입
		if(dept_id.equals("all")) {
			dept_id = null;
		}
		if(type.equals("empty")) {
			type = null;
		}
		if(keyword.equals("empty")) {
			keyword = null;
		}
		
		// 검색 설정과 일치하는 로우 페이징처리하여 가져오기
		TaskCriteria cri = new TaskCriteria(pageNum, type, keyword, dept_id);
		
		mav.addObject("dto", service.getList(cri));
		
		return mav;
	}
	
	// 업무 개별 보기
	@GetMapping(value="/pages/{dept_id}/{type}/{keyword}/{pageNum}/{task_id}")
	public ModelAndView getTask(
			@PathVariable() String dept_id, @PathVariable String type, @PathVariable String keyword,
			@PathVariable Integer pageNum, @PathVariable Integer task_id) {
		
		ModelAndView mav = new ModelAndView("/task/TSK_detail");
		
		mav.addObject("type", type);
		mav.addObject("keyword", keyword);
		mav.addObject("pageNum", pageNum);
		mav.addObject("task", service.getTask(task_id));
		
		return mav;
	}
	
	
	// 비공개 게시물 접근 시 처리
	@GetMapping(value="/accessDenied")
	public ModelAndView accessDenied() {
		ModelAndView mav = new ModelAndView("/task/TSK_denied");
		
		return mav;
	}
	
	
	// 업무 등록 폼으로 이동
	@GetMapping(value="/new")
	public ModelAndView insertForm() {
		
		ModelAndView mav = new ModelAndView("/task/TSK_new");
		
		return mav;
		
	}
	
	// 업무 등록
	@PostMapping(value="/new")
	public ResponseEntity<String> insertTask(@RequestBody TaskVO vo) {

		return service.insertTask(vo) ?
			new ResponseEntity<String>("success", HttpStatus.OK) :
			new ResponseEntity<String>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 업무 수정
	@RequestMapping(method = {RequestMethod.PATCH, RequestMethod.PUT},
				value="/pages/{dept_id}/{type}/{keyword}/{pageNum}/{task_id}")
	public ResponseEntity<String> updateTask(@RequestBody TaskVO vo,
			@PathVariable String dept_id, @PathVariable String type, @PathVariable String keyword,
			@PathVariable Integer pageNum, @PathVariable Integer task_id, Model model) {

		return service.updateTask(vo) ?
				new ResponseEntity<String>("success", HttpStatus.OK) :
				new ResponseEntity<String>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 업무 삭제
	@DeleteMapping(value="/{task_id}")
	public ResponseEntity<String> deleteTask(@PathVariable Integer task_id) {
		
		return service.deleteTask(task_id) ?
				new ResponseEntity<String>("success", HttpStatus.OK) :
				new ResponseEntity<String>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 파일 등록
	@PostMapping(value="/uploadFile",
				produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<FileVO>> uploadFile(MultipartFile[] uploadFile) {
		
		// 파일에 대하 정보를 리스트에 담아 리턴하기 위해 list 선언
		List<FileVO> list = new ArrayList<FileVO>();
		
		// 파일 업로드 폴더 경로
		String uploadFolder = "C:\\upload";
		
		// 날짜에 맞는 업로드 폴더 존재 확인(없을 경우 생성)
		File uploadPath = new File(uploadFolder, getFolder());
		if(uploadPath.exists() == false) {
			uploadPath.mkdirs();
		} // 년/월/일 경로 생성
		
		// 업로드 파일을 하나씩 처리
		for(MultipartFile m : uploadFile) {
			
			FileVO vo = new FileVO();
			
			// 파일 저장 경로
			vo.setFile_src(getFolder());
			
			// uuid 생성
			UUID uuid = UUID.randomUUID();
			// uuid 파일객체에 저장
			vo.setUuid(uuid.toString());
			
			// 업로드 파일 실제 이름
			String uploadFileName = m.getOriginalFilename();
			// 파일명 vo객체에 저장
			vo.setFile_name(uploadFileName);
			
			// uuid + 실제 파일명
			uploadFileName = uuid.toString() + "_" + uploadFileName;
			
			try {
				// 파일 객체 생성
				File saveFile = new File(uploadPath, uploadFileName);
				// 실제 파일 업로드를 진행하는 메소드
				m.transferTo(saveFile);
				
				list.add(vo);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		return new ResponseEntity<List<FileVO>>(list, HttpStatus.OK);
		
	} // end uploadFile
	
	
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
	
	@Transactional
	@DeleteMapping("/deleteFile")
	public ResponseEntity<String> deleteFile(@RequestBody FileVO vo) {
		File file;
		
		log.info(vo.getFile_name());
		log.info(vo.getUuid());
		// DB까지 업로드된 경우 DB에서 해당 데이터 삭제
		if(vo.getUuid() != null) {
			mapper.deleteTaskFile(vo.getUuid());
		}
		
		try {
			// 삭제 대상을 파일 객체로 만듦
			file = new File("C:\\upload\\" + vo.getFile_name());
			// 실제 파일이 존재하는 경우 삭제
			if(file.exists()) {
				file.delete();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<String>("삭제 완료", HttpStatus.OK);
		
	}
	
	
	
	
	// 메소드
	
	// 파일 저장 폴더를 위한 메소드
	private String getFolder() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		
		String str = df.format(date);
		
		return str.replace("-", File.separator);
	}

}
