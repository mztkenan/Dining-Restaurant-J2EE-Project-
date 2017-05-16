package com.cugb.javaee.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.cugb.javaee.dao.IUserDao;
import com.cugb.javaee.utils.DaoFactory;

public class UserDaoImplTest {
	IUserDao iUserDao = (IUserDao) DaoFactory.newInstance("IUserDao");
	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testFindUsers() {
		iUserDao.findUsers();
		//fail("Not yet implemented");
	}

	@Test
	public void testFindUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteUser() {
		fail("Not yet implemented");
	}

}
