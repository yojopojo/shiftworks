package org.shiftworks.mapper;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.shiftworks.domain.EmployeeVO;
import org.shiftworks.domain.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class EmployeeMapperTests {
	
	@Autowired
	private EmployeeMapper empMapper;
	

	@Test
	public void loginTest() {
		
		EmployeeVO empVO = empMapper.read("user1");
		
		log.info(empVO);

		
		
	}

}
