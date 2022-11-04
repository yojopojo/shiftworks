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
		String sql = "INSERT INTO employee(emp_id, password, name, dept_id) values(?, ?, ?, ?)";
		
		for(int i=0; i<30; i++) {
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				
				// pw1, pw2, pw3... 형식으로 비밀번호 설정
				pstmt.setString(2, pwEncoder.encode("pw" + i));
				
				if(i<10) {
					// user1, user2, user3... 형식으로 아이디 설정
					pstmt.setString(1, "user" + i);
					pstmt.setString(3, "u" + i);
					// dept1 이라는 부서 값 부여
					pstmt.setString(4, "dept" + 1);
				} else if(i<20) {
					pstmt.setString(1, "user" + i);
					pstmt.setString(3, "u" + i);
					pstmt.setString(4, "dept" + 2);
				} else {
					pstmt.setString(1, "user" + i);
					pstmt.setString(3, "u" + i);
					pstmt.setString(4, "dept" + 3);
				}
				
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				// 자원 반납
				if(pstmt != null) { try {pstmt.close();} catch(Exception e) {} }
				if(con != null) { try {con.close();} catch(Exception e) {} }
			}
		}// end for
	}// end test
	
	
}
