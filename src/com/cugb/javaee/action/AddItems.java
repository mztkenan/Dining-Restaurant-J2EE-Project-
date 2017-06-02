/**
 * 
 */
package com.cugb.javaee.action;

import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.Timestamp;
import java.util.ArrayList;

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
import com.cugb.javaee.dao.IUserDao;
import com.cugb.javaee.utils.DaoFactory;

/**
 * @author Beyond
 *
 */
public class AddItems extends HttpServlet {
	//思路混乱，没有写好
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String productId = request.getParameter("PID");
		String pnumber = request.getParameter("PNumber");
		//形成购物车变量
		CartItem cartItem=new CartItem();
		IProductDao iProductDao = (IProductDao) DaoFactory.newInstance("IProductDao");
		Product tmpProduct = iProductDao.findProduct(productId);
		cartItem.setDish(tmpProduct);
		cartItem.setQuantity(Integer.parseInt(pnumber));
		//把购物车变量放进session，用arraylist形式来组织
		HttpSession session = request.getSession(false);
		ArrayList<CartItem> cartItemArray=(ArrayList<CartItem>) session.getAttribute("carItemArray");
		if(cartItemArray == null){
			ArrayList<CartItem> tmpcartItemArray=new ArrayList<CartItem>();
			tmpcartItemArray.add(cartItem);
			session.setAttribute("carItemArray", tmpcartItemArray);
		}else{
			cartItemArray.add(cartItem);
			//覆盖旧变量
			session.setAttribute("carItemArray", cartItemArray);
		}
		
		String url = response.encodeRedirectURL(request  
                .getContextPath() + "/Menu.jsp");  
        response.sendRedirect(url);  

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
