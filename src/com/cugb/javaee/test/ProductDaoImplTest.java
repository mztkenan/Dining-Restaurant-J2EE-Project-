package com.cugb.javaee.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.cugb.javaee.dao.IProductDao;
import com.cugb.javaee.dao.IUserDao;
import com.cugb.javaee.utils.DaoFactory;

public class ProductDaoImplTest {
	IProductDao iProductDao = (IProductDao) DaoFactory.newInstance("IProductDao");
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindProducts() {
		assertTrue(iProductDao.findProducts()!=null);
	}

	@Test
	public void testFindProduct() {
		//fail("Not yet implemented");
	}

	@Test
	public void testInsertProduct() {
		//fail("Not yet implemented");
	}

	@Test
	public void testUpdateProduct() {
		//fail("Not yet implemented");
	}

	@Test
	public void testDeleteProduct() {
		//fail("Not yet implemented");
	}

}
