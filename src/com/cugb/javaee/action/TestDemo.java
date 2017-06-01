package com.cugb.javaee.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

public class TestDemo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");  
        response.setHeader("Content-type", "text/html;charset=UTF-8");  
		PrintWriter out = response.getWriter();  
        out.print("用户名不合法或者已经被注册");  
        JOptionPane.showMessageDialog(null, "用户名不合法或者已经被注册", "注意", 
        		JOptionPane.ERROR_MESSAGE);   
        String url = response.encodeRedirectURL(request.getContextPath() + "/index.jsp");  
        response.sendRedirect(url);  
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
