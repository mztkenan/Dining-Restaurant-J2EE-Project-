package com.cugb.javaee.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cugb.javaee.bean.User;

public class UserLogOut extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//注销
		 response.setCharacterEncoding("UTF-8");  
        response.setHeader("Content-type", "text/html;charset=UTF-8");  
        PrintWriter out = response.getWriter();  
        HttpSession session = request.getSession(false); 
    	session.removeAttribute("user");  
    	session.invalidate(); 
        String url = response.encodeRedirectURL(request.getContextPath() + "/Menu.jsp");  
    	response.sendRedirect(url);
	}

}
