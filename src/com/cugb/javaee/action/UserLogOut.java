package com.cugb.javaee.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserLogOut extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		//注销
		 response.setCharacterEncoding("UTF-8");  
	        response.setHeader("Content-type", "text/html;charset=UTF-8");  
	        PrintWriter out = response.getWriter();  
	        HttpSession session = request.getSession(false);  
	        if (session == null) {  
	            // 没登录，重定向到首页  
	            String url = response.encodeRedirectURL(request.getContextPath()  
	                    + "/index.jsp");  
	            response.sendRedirect(url);  
	            return;  
	        }  
	        // 从session中移除登录状态  
	        session.removeAttribute("user");  
	        // 重定向到首页，URL重写方式  
	        String url = response.encodeRedirectURL(request.getContextPath()  
	                + "/index.jsp");  
	        response.sendRedirect(url);  
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}