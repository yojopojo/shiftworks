package org.shiftworks.security;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"
})
@Log4j
public class EmployeeTests {

	@Autowired
	private PasswordEncoder pwEncoder;
	
	@Autowired
	private DataSource ds;
	
	// 사용자 추가
	@Test
	public void testInsertMember() {
		String sql = "INSERT INTO employee(emp_id, dept_id, password, name, address, birthday, position, mobile, internal, email, entry_date) values(?, ?, ?, ?, ?, ? ,? ,? ,? ,? ,?)";
		
		for(int i=1; i<71; i++) {
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				
				// pw1, pw2, pw3... 형식으로 비밀번호 설정
				pstmt.setString(3, pwEncoder.encode("pw" + i));
				
				if(i<21) {
					pstmt.setString(1, "user" + i);
					pstmt.setString(2, "dept1");
					pstmt.setString(4, "이름"+i);
					pstmt.setString(5, "주소"+i);
					pstmt.setString(6, "1990.09.09");
					pstmt.setString(7, "직급");
					pstmt.setString(8, "010-"+i);
					pstmt.setString(9, "091-"+i);
					pstmt.setString(10, "id"+i+"@mail.com");
					pstmt.setString(11, "2020.03.05");
				}else if(i<41) {
					pstmt.setString(1, "user" + i);
					pstmt.setString(2, "dept2");
					pstmt.setString(4, "이름"+i);
					pstmt.setString(5, "주소"+i);
					pstmt.setString(6, "1993.11.11");
					pstmt.setString(7, "직급");
					pstmt.setString(8, "010-"+i);
					pstmt.setString(9, "091-"+i);
					pstmt.setString(10, "id"+i+"@mail.com");
					pstmt.setString(11, "2020.12.05");
				
				}else if(i<51) {
					pstmt.setString(1, "user" + i);
					pstmt.setString(2, "dept3");
					pstmt.setString(4, "이름"+i);
					pstmt.setString(5, "주소"+i);
					pstmt.setString(6, "1993.11.11");
					pstmt.setString(7, "직급");
					pstmt.setString(8, "010-"+i);
					pstmt.setString(9, "091-"+i);
					pstmt.setString(10, "id"+i+"@mail.com");
					pstmt.setString(11, "2020.02.15");
				
				}else {
					pstmt.setString(1, "admin" + i);
					pstmt.setString(2, "infosecu");
					pstmt.setString(4, "이름"+i);
					pstmt.setString(5, "주소"+i);
					pstmt.setString(6, "1990.12.11");
					pstmt.setString(7, "직급");
					pstmt.setString(8, "010-"+i);
					pstmt.setString(9, "091-"+i);
					pstmt.setString(10, "id"+i+"@mail.com");
					pstmt.setString(11, "2020.01.05");	
				}
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// 자원 반납
				if(pstmt != null) { try {pstmt.close();} catch(Exception e) {} }
				if(con != null) { try {con.close();} catch(Exception e) {} }
			}
		}// end for1

	}// end test
	

}
