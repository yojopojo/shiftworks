package org.shiftworks.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.shiftworks.domain.PostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
									  "file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Log4j
public class PostControllerTests {
	
	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	public void testInsertPost() throws Exception{
		
		PostVO vo = new PostVO();
		vo.setB_id(2);
		vo.setDept_id("11");
		vo.setEmp_id("1002");
		vo.setPost_name("controller 테스트");
		vo.setPost_content("controller 테스트입니다");
		vo.setPost_receivedept("12");
		
		String jsonStr = new Gson().toJson(vo);
		log.info(jsonStr);
		
		mockMvc.perform(post("/board/new")
					.contentType(MediaType.APPLICATION_JSON)
					.content(jsonStr))
					.andExpect(status().is(200));
		
	}

}
