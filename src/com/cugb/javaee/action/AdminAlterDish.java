package com.cugb.javaee.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cugb.javaee.bean.Product;
import com.cugb.javaee.dao.IProductDao;
import com.cugb.javaee.utils.DaoFactory;

public class AdminAlterDish extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//向数据库的product修改一条数据
		IProductDao iProductDao = (IProductDao) DaoFactory.newInstance("IProductDao");
		String productId =  request.getParameter("productId");
		String productName = request.getParameter("productName");
		float productPrice =Float.valueOf( request.getParameter("productPrice"));
		int productRemained = Integer.parseInt(request.getParameter("productRemained"));
		String productDescription = request.getParameter("productDescription");
		String productImage = request.getParameter("productImage");
		Product product = new Product(productId,productName,productPrice,productRemained,productDescription,productImage);
		iProductDao.updateProduct(product);
		// 重定向到首页，URL重写方式  
        String url = response.encodeRedirectURL(request.getContextPath() + "/index.jsp");  
        response.sendRedirect(url);  
	}
	
}
