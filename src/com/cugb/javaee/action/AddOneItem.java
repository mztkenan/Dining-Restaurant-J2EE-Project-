package com.cugb.javaee.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cugb.javaee.bean.CartItem;

public class AddOneItem extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		ArrayList<CartItem> cartItemArray=(ArrayList<CartItem>) session.getAttribute("carItemArray");
		String PID=request.getParameter("AddOnePID");
		for(int i= 0 ; i<cartItemArray.size() ; i++){
			if(cartItemArray.get(i).getDish().getProductId().equals(PID)){
				cartItemArray.get(i).setQuantity
				(cartItemArray.get(i).getQuantity()+1);
				break;
			}
		}
		session.setAttribute("carItemArray", cartItemArray);
		String url = response.encodeRedirectURL(request  
                .getContextPath() + "/shopCart.jsp");  
        response.sendRedirect(url); 
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
