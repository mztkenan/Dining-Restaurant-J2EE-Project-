package com.cugb.javaee.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.cugb.javaee.bean.User;
import com.cugb.javaee.dao.IUserDao;
import com.cugb.javaee.utils.DaoFactory;

public class UserDaoImplTest {
	IUserDao iUserDao = (IUserDao) DaoFactory.newInstance("IUserDao");
	User user = new User();
	@Before
	public void setUp() throws Exception {
		user.setUserId("4");
		user.setUsername("1");
		user.setPassword("1");
		user.setUserType(1);
	}
/*
	@Test
	public void testFindUsers() {
		ArrayList<User> list = (ArrayList<User>) iUserDao.findUsers();
		
		//fail("Not yet implemented");
	}

	@Test
	public void testInsertUser() {
		iUserDao.insertUser(user);
		//fail("Not yet implemented");
	}

	@Test
	public void testFindUser() {
		
		//fail("Not yet implemented");
	}
/*
	@Test
	public void testUpdateUser() {
		user.setPassword("2");
		iUserDao.updateUser(user);
		//fail("Not yet implemented");
	}

	@Test
	public void testDeleteUser() {
		iUserDao.deleteUser(user);
		//fail("Not yet implemented");
	}
	
	@Test
	public void testlogin() {
		
		
		//fail("Not yet implemented");
	}

	@Test
	public void testFindUsername() {
		
		//fail("Not yet implemented");
	}
*/
	/*
	@Test
	public void testCountRows() {
		
		//fail("Not yet implemented");
	}*/
	
	@Test
	public void testFindUser() {
		iUserDao.findUser("1");
		//fail("Not yet implemented");
	}
}
