package org.shiftworks.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.shiftworks.mapper.ApprovalMapperTests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
		{"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class ApprovalControllerTests {

	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
//	
//	@Test
//	public void testList() throws Exception{
//		log.info(
//				mockMvc.perform(MockMvcRequestBuilders.get("/approval/list"))
//				.andReturn()
//				.getModelAndView()
//				.getModelMap()
//				);
//		
//	}
	
//	@Test
//	public void testInsert() throws Exception{
//		
//		String resultPage = mockMvc
//			.perform(MockMvcRequestBuilders.post("/approval/insert")
//				.param("apr_id", "4")
//				.param("apr_title", "결제명")
//				.param("apr_content", "결재사항")
//				.param("apr_check", "4")
//				.param("apr_status", "4"))
//			.andReturn().getModelAndView().getViewName();
//		
//		log.info(resultPage);
//			
//	}
	
//	@Test
//	public void testGet() throws Exception{
//		log.info(mockMvc.perform(MockMvcRequestBuilders
//				.get("/approval/get")
//				.param("apr_id", "2"))
//				.andReturn()
//				.getModelAndView().getModelMap());
//	}
//	
//	@Test
//	public void testUpdate() throws Exception{
//		
//		String resultPage = mockMvc
//			.perform(MockMvcRequestBuilders.post("/approval/update")
//				.param("apr_id", "43")
//				.param("apr_title", "수정 날짜 확인")
//				.param("apr_comment", "수정 날짜 확인")
//				.param("apr_status", "0"))
//			.andReturn().getModelAndView().getViewName();
//		
//		log.info(resultPage);
//			
//	}
	
	@Test
	public void testListPaging() throws Exception{
		
		log.info(mockMvc.perform(
				MockMvcRequestBuilders.get("/approval/list")
				.param("pageNum", "2")
				.param("amount", "50"))
				.andReturn().getModelAndView().getModelMap());			
				}
	
	
	
}
