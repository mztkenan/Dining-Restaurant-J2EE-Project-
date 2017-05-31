package com.cugb.javaee.dao;

import java.util.ArrayList;

import com.cugb.javaee.bean.Product;

public interface IProductDao {
	public ArrayList<Product> findProducts();
	public boolean findProduct(Product product);
	public int insertProduct(Product product);
	public int updateProduct(Product product);
	public int deleteProduct(Product product);
	public int getTotalNum();
	public ArrayList<Product> findDishesBySize(String strsql, Object[] params);
}
