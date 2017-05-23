package com.cugb.javaee.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.cugb.javaee.bean.Product;
import com.cugb.javaee.dao.IProductDao;
import com.cugb.javaee.utils.DaoFactory;

public class ProductDaoImplTest {
	IProductDao iProductDao = (IProductDao) DaoFactory.newInstance("IProductDao");
	Product product = new Product();
	@Before
	public void setUp() throws Exception {
		product.setProductId("1");
		product.setProductName("1");
		product.setProductPrice((float) 1.0);
		product.setProductRemained(1);
		product.setProductDescription("0");
		product.setProductImage("0");
	}

	@Test
	public void testFindProducts() {
		iProductDao.findProducts();
		//fail("Not yet implemented");
	}
	
	@Test
	public void testInsertProduct() {
		iProductDao.insertProduct(product);
		//fail("Not yet implemented");
	}
	
	@Test
	public void testFindProduct() {
		iProductDao.findProduct(product);
		//fail("Not yet implemented");
	}
	
	@Test
	public void testUpdateProduct() {
		product.setProductRemained(2);
		product.setProductDescription("1");
		iProductDao.updateProduct(product);
		//fail("Not yet implemented");
	}

	@Test
	public void testDeleteProduct() {
		iProductDao.deleteProduct(product);
		//fail("Not yet implemented");
	}

}
