package com.cugb.javaee.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cugb.javaee.bean.CartItem;
import com.cugb.javaee.bean.OrderInfomation;
import com.cugb.javaee.bean.Product;
import com.cugb.javaee.bean.User;
import com.cugb.javaee.dao.IOrderInfomationDao;
import com.cugb.javaee.dao.IProductDao;
import com.cugb.javaee.utils.DaoFactory;

public class OrderPay extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		public OrderInfomation(String orderId, String userId, String orderAddress,
//				String orderPhone, Timestamp orderDate, float orderPrice,String orderState, 
//				String orderRemark){
//			this.orderId = orderId;
//			this.userId = userId;
//			this.orderAddress = orderAddress;
//			this.orderPhone = orderPhone;
//			this.orderDate = orderDate;      
//			this.orderPrice = orderPrice;
//			this.orderState = orderState;
//			this.orderRemark = orderRemark;
//		}
		String orderAddress = request.getParameter("orderAddress");
		String orderPhone = request.getParameter("orderPhone");
		Timestamp dateTime = new Timestamp(System.currentTimeMillis()); 
		HttpSession session = request.getSession(false); 
		User user = (User) session.getAttribute("user");
		ArrayList<CartItem> cartItemArray=(ArrayList<CartItem>) session.getAttribute("carItemArray");
		IOrderInfomationDao iOrderInfomationDao = (IOrderInfomationDao) DaoFactory.newInstance("IOrderInfomationDao");
		IProductDao iProductDao = (IProductDao) DaoFactory.newInstance("IProductDao");
		for(int i=0; i < cartItemArray.size() ; i++){
			//改变订单状态
			Product product = iProductDao.findProduct(cartItemArray.get(i).getDish().getProductId());
			Double prise = (double) (cartItemArray.get(i).getQuantity()*product.getProductPrice());
			String OrderId=iOrderInfomationDao.countOrderInfomation();
			OrderInfomation orderInfomation = new OrderInfomation(OrderId,user.getUserId(),orderAddress,orderPhone,dateTime,prise.toString(),"Unpay","");
			iOrderInfomationDao.insertOrderInfomation(orderInfomation);
			iOrderInfomationDao.updateOrderInfomation(user.getUserId(), OrderId, "Unpay", "Paied");
			//减少库存
			
			iProductDao.updateProductNumber(cartItemArray.get(i).getDish().getProductId(), cartItemArray.get(i).getQuantity());
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
