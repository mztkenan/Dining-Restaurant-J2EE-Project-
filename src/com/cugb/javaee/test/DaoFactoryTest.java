package com.cugb.javaee.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.cugb.javaee.utils.DaoFactory;

public class DaoFactoryTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testNewInstance() {
		assertNotNull(DaoFactory.newInstance("IUserDAO"));
	}

}
