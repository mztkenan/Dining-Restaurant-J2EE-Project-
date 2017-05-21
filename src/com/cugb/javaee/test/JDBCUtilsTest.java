package com.cugb.javaee.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.cugb.javaee.utils.JDBCUtils;

public class JDBCUtilsTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws SQLException {
		Connection conn = null;
		for(int i=0;i<4;i++){
			conn = JDBCUtils.getConnection();
			System.out.println(conn);
			conn.close();
		}
	}

}
