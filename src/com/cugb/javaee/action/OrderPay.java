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
import javax.websocket.Session;

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
		HttpSession session = request.getSession(false); 
		User user = (User) session.getAttribute("user");
		if(user==null){
	       	request.setAttribute("wrongMessage", "您未登录，请先登录");
        	request.getRequestDispatcher("Menu.jsp").forward(request, resp);
        	return;
		}
		String orderAddress = request.getParameter("orderAddress");
		String orderPhone = request.getParameter("orderPhone");
		String orderText = request.getParameter("orderText");
		//时间戳给订单添加编号
		Timestamp dateTime = new Timestamp(System.currentTimeMillis()); 
		
		
		ArrayList<CartItem> cartItemArray=(ArrayList<CartItem>) session.getAttribute("carItemArray");
		IOrderInfomationDao iOrderInfomationDao = (IOrderInfomationDao) DaoFactory.newInstance("IOrderInfomationDao");
		IProductDao iProductDao = (IProductDao) DaoFactory.newInstance("IProductDao");
		if(cartItemArray==null){
			request.setAttribute("isShopCartEmpty", "您的购物车为空");
			request.getRequestDispatcher("Menu.jsp").forward(request, resp);
		}
		else
		for(int i=0; i < cartItemArray.size() ; i++){
			//鏀瑰彉璁㈠崟鐘舵��
			Product product = iProductDao.findProduct(cartItemArray.get(i).getDish().getProductId());
			Float prise = (Float) (cartItemArray.get(i).getQuantity()*product.getProductPrice());
			String OrderId=iOrderInfomationDao.countOrderInfomation();
			OrderInfomation orderInfomation = new OrderInfomation(OrderId,user.getUserId(),orderAddress,orderPhone,dateTime,prise,"Unpay",orderText);
			iOrderInfomationDao.insertOrderInfomation(orderInfomation);
			iOrderInfomationDao.updateOrderInfomation(user.getUserId(), OrderId, "Unpay", "Paied");
			//鍑忓皯搴撳瓨
			
			iProductDao.updateProductNumber(cartItemArray.get(i).getDish().getProductId(), cartItemArray.get(i).getQuantity());
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
