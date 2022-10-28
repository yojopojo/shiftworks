package org.shiftworks.security;

import static org.junit.Assert.*;

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
public class UserTests {
	
	@Autowired
	private PasswordEncoder pwencoder;
	
	@Autowired
	private DataSource ds;

	@Test
	public void testInsertUser() {
		
		String sql = "insert into employee(emp_id, password, name, dept_id) values (?, ?, ?, ?)";
		
		for(int i=1;i<=10;i++) {
			
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(2, pwencoder.encode("shiftworks113"));
				
				if(i<7) {
					
					pstmt.setString(1, "user"+i);
					pstmt.setString(3, "name"+i);
					pstmt.setString(4, "dept1");
					
				}else if(i<8){
					
					pstmt.setString(1, "manager"+i);
					pstmt.setString(3, "mngname"+i);
					pstmt.setString(4, "dept2");
					
				}else {
					
					pstmt.setString(1, "admin"+i);
					pstmt.setString(3, "admname"+i);
					pstmt.setString(4, "infosecu1");
				}
				
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
			    if(pstmt != null) { try { pstmt.close();  } catch(Exception e) {} }
		        if(con != null) { try { con.close();  } catch(Exception e) {} }
	        
			}
		}//end for
	}//인증, 권한 테스트를 위한 employee 테이블에 dummy data insert

//	@Test
//	  public void testInsertAuth() {
//	    
//	    
//	    String sql = "insert into department (dept_id, dept_name, authority) values (?,?,?)";
//	    
//	    for(int i = 2; i < 6; i++) {
//	      
//	      Connection con = null;
//	      PreparedStatement pstmt = null;
//	      
//	      try {
//	        con = ds.getConnection();
//	        pstmt = con.prepareStatement(sql);
//	      
//	        
//	        if(i <5) {
//	          
//	          pstmt.setString(1, "dept"+i);
//	          pstmt.setString(2, "normal");
//	          pstmt.setString(3,"user");
//	          
//	        }else {
//	          
//	        	   pstmt.setString(1, "infosecu2");
//	        	   pstmt.setString(2, "secu111");
//	 	          pstmt.setString(3,"admin");
//	          
//	        }
//	        
//	        pstmt.executeUpdate();
//	        
//	      }catch(Exception e) {
//	        e.printStackTrace();
//	      }finally {
//	        if(pstmt != null) { try { pstmt.close();  } catch(Exception e) {} }
//	        if(con != null) { try { con.close();  } catch(Exception e) {} }
//	        
//	      }
//	    }//end for
//	  }//인증, 권한 테스트를 위한 departmet 테이블에 dummy data insert

	
}
