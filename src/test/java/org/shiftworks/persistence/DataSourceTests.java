package org.shiftworks.persistence;

<<<<<<< HEAD
import static org.junit.Assert.fail;
=======
import static org.junit.Assert.*;
>>>>>>> 8cb29c105541cd75009d68f2eee7f7946591589e

import java.sql.Connection;

import javax.sql.DataSource;

<<<<<<< HEAD
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
=======
>>>>>>> 8cb29c105541cd75009d68f2eee7f7946591589e
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

<<<<<<< HEAD
import lombok.Setter;
import lombok.extern.log4j.Log4j;

=======
import lombok.extern.log4j.Log4j;


>>>>>>> 8cb29c105541cd75009d68f2eee7f7946591589e
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTests {
<<<<<<< HEAD

	@Setter(onMethod_ = { @Autowired })
	private DataSource dataSource;

	@Setter(onMethod_ = { @Autowired })
	private SqlSessionFactory sqlSessionFactory;

	@Test
	public void testMyBatis() {

		try (SqlSession session = sqlSessionFactory.openSession(); Connection con = session.getConnection();) {
			log.info(session);
			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testConnection() {

		try (Connection con = dataSource.getConnection()) {
			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
=======
	
	@Autowired
	private DataSource dataSource;
	

	@Test
	public void test() {
		try {
			Connection con = dataSource.getConnection();
			log.info(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
>>>>>>> 8cb29c105541cd75009d68f2eee7f7946591589e
