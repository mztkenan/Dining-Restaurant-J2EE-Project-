package com.cugb.javaee.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cugb.javaee.bean.CartItem;

public class DeleteOneItem extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		ArrayList<CartItem> cartItemArray = (ArrayList<CartItem>) session.getAttribute("carItemArray");
		String PID = request.getParameter("DeleteOnePID");
		for (int i = 0; i < cartItemArray.size(); i++) {
			if (cartItemArray.get(i).getDish().getProductId().equals(PID)) {
				if (cartItemArray.get(i).getQuantity() >= 2) {
					cartItemArray.get(i).setQuantity(cartItemArray.get(i).getQuantity() - 1);
				}
				break;
			}
		}
		session.setAttribute("carItemArray", cartItemArray);
		String url = response.encodeRedirectURL(request.getContextPath() + "/shopCart.jsp");
		response.sendRedirect(url);
	}

}
