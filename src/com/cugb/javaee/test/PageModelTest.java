package com.cugb.javaee.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.cugb.javaee.dao.IProductDao;
import com.cugb.javaee.utils.DaoFactory;

public class PageModelTest {
	IProductDao iProductDao = (IProductDao) DaoFactory.newInstance("IProductDao");
	@Before
	public void setUp() throws Exception {
	}


	@Test
	public void testGetTotalNum(){
		assertTrue(iProductDao.getTotalNum()==3);
		System.out.println(iProductDao.getTotalNum());
	}

}
