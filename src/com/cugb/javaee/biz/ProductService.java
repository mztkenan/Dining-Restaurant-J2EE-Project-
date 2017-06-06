package com.cugb.javaee.biz;

import java.util.ArrayList;

import com.cugb.javaee.bean.Product;
import com.cugb.javaee.dao.IProductDao;
import com.cugb.javaee.utils.DaoFactory;
import com.cugb.javaee.utils.PageModel;

public class ProductService {
    private IProductDao iDao=(IProductDao)DaoFactory.newInstance("IProductDao");   
    public IProductDao getiDao() {
		return iDao;
	}

	public void setiDao(IProductDao iDao) {
		this.iDao = iDao;
	}
	
	public PageModel<Product> showPagelist(int currentPage,int pageSize) {
		
		String sql="select productid ProductId,productRemained ProductRemained,productname ProductName,productImage ProductImage,productPrice  ProductPrice,productDescription ProductDescription from product limit ?,?";
		int recordStartNum = (currentPage-1)*pageSize;
		Object[] params = {recordStartNum,pageSize};
		ArrayList<Product> list=iDao.findDishesBySize(sql,params);
		PageModel<Product> pageModel = new PageModel<Product>(iDao.getTotalNum(),pageSize,currentPage,list);
		
		return  pageModel;
	}
}
