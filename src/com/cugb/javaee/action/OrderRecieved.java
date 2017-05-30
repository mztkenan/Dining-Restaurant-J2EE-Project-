package com.cugb.javaee.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cugb.javaee.bean.OrderInfomation;
import com.cugb.javaee.bean.User;
import com.cugb.javaee.dao.IOrderInfomationDao;
import com.cugb.javaee.utils.DaoFactory;

public class OrderRecieved extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		
		String OrderId = request.getParameter("OID");
		HttpSession session = request.getSession(false); 
		User user = (User) session.getAttribute("user");
		IOrderInfomationDao iOrderInfomationDao = (IOrderInfomationDao) DaoFactory.newInstance("IOrderInfomationDao");
		iOrderInfomationDao.updateOrderInfomation(user.getUserId(), OrderId, "Paied", "Recieved");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
