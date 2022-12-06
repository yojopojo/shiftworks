package org.shiftworks.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
	})
@Log4j
public class BookingControllerTests {
	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup()	{
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
//	@Test
//	public void insertBookingTestC() throws Exception {
//		
//	int re = mockMvc.perform(MockMvcRequestBuilders.post("/board/new")
//			.param("book_id", "3")
//			
//				.andReturn().getModelAndView().getViewName(); //어디로 가는 지 궁금 > getViewName
//				
//		log.info(re);
//	}
	
//	vo.setBook_id(2);
//	vo.setRsc_id("CFR305");
//	vo.setDept_id("IMP");
//	vo.setEmp_id("IMP3056");
//	vo.setBook_date("2022-10-25");
//	vo.setBook_begin(10);
//	vo.setBook_title("reserv mapper test");
//	vo.setBook_content("something something blah");
//	int re = mapper.insertBooking(vo);

	
	
	
	@Test
	public void testListPaging() throws Exception{
		
		log.info(mockMvc.perform(
				MockMvcRequestBuilders.get("/booking/list")
				.param("pageNum", "2")
				.param("amount", "4"))
				.andReturn().getModelAndView().getModelMap());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
