package org.shiftworks.persistence;


import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
<<<<<<< HEAD

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testConnection() {

		try (Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:XE", 
				"shiftworks",
		        "sw1234")) {
			log.info(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
=======
   
   
   static {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
      }catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   @Test
   public void testConnection() {
      
      try(Connection con =
    		  DriverManager.getConnection(
                  "jdbc:oracle:thin:@localhost:1521:XE",
                  "shiftworks",
                  "sw1234"
                  )){
         log.info(con);
      }catch (Exception e) {
         e.printStackTrace();
      }
   }
}
>>>>>>> 8cb29c105541cd75009d68f2eee7f7946591589e
