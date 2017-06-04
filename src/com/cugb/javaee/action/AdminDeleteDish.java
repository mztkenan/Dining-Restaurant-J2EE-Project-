package com.cugb.javaee.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cugb.javaee.bean.Product;
import com.cugb.javaee.dao.IProductDao;
import com.cugb.javaee.utils.DaoFactory;

public class AdminDeleteDish extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IProductDao iProductDao = (IProductDao) DaoFactory.newInstance("IProductDao");
		String productId =  request.getParameter("productId");
		Product product = new Product();
		product.setProductId(productId);
		iProductDao.deleteProduct(product);
		// 重定向到首页，URL重写方式  
        String url = response.encodeRedirectURL(request.getContextPath() + "/index.jsp");  
        response.sendRedirect(url);  
	}

}
