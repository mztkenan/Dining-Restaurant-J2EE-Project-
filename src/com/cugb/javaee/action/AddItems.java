/**
 * 
 */
package com.cugb.javaee.action;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cugb.javaee.bean.OrderInfomation;
import com.cugb.javaee.bean.Product;
import com.cugb.javaee.bean.User;
import com.cugb.javaee.dao.IOrderInfomationDao;
import com.cugb.javaee.dao.IUserDao;
import com.cugb.javaee.utils.DaoFactory;

/**
 * @author Beyond
 *
 */
public class AddItems extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String productId = request.getParameter("PID");
		Product product = new Product();
		HttpSession session = request.getSession(false); 
		User user = (User) session.getAttribute("user");
//		OrderInfomation orderInfomation = new OrderInfomation(String orderId, user.getUserId(), 
//				String orderAddress,	String orderPhone, Timestamp orderDate, 
//				float orderPrice,String orderState, String orderRemark);
		String productNumbers = request.getParameter("PNumber");
		IOrderInfomationDao iOrderInfomation = (IOrderInfomationDao) DaoFactory.newInstance("IOrderInfomationDao");
		iOrderInfomation.insertOrderInfomation(orderInfomation);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
