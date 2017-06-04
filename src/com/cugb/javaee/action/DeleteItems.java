package com.cugb.javaee.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cugb.javaee.bean.CartItem;
import com.mysql.jdbc.PingTarget;

public class DeleteItems extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		ArrayList<CartItem> cartItemArray=(ArrayList<CartItem>) session.getAttribute("carItemArray");
		String PID=request.getParameter("deletePID");
		for(int i= 0 ; i<cartItemArray.size() ; i++){
			if(cartItemArray.get(i).getDish().getProductId().equals(PID)){
				cartItemArray.remove(i);
				break;
			}
		}
		session.setAttribute("carItemArray", cartItemArray);
		String url = response.encodeRedirectURL(request  
                .getContextPath() + "/shopCart.jsp");  
        response.sendRedirect(url); 
	}

}
