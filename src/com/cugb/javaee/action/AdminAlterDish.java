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
		//鍚戞暟鎹簱鐨刾roduct淇敼涓�鏉℃暟鎹�
		request.setCharacterEncoding("utf-8");
		String productId =  request.getParameter("productId");
		
		IProductDao iProductDao = (IProductDao) DaoFactory.newInstance("IProductDao");
		
		
		String productName = request.getParameter("productName");
		float productPrice =Float.valueOf( request.getParameter("productPrice"));
		int productRemained = Integer.parseInt(request.getParameter("productRemained"));
		String productDescription = request.getParameter("productDescription");
		String productImage = request.getParameter("productImage");
		Product product = new Product(productId,productName,productPrice,productRemained,productDescription,productImage);
		iProductDao.updateProduct(product);
		// 閲嶅畾鍚戝埌棣栭〉锛孶RL閲嶅啓鏂瑰紡  
		
		String url = response.encodeRedirectURL(request.getContextPath() + "/FoodManage.jsp");  
        response.sendRedirect(url);  
        
	}
	
}
