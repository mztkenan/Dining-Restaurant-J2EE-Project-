package com.cugb.javaee.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cugb.javaee.bean.User;
import com.cugb.javaee.dao.IUserDao;
import com.cugb.javaee.utils.DaoFactory;

public class DeleteUser extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String UID = request.getParameter("deleteUID");
		User tmpu = new User();
		tmpu.setUserId(UID);
		IUserDao iUserDao = (IUserDao) DaoFactory.newInstance("IUserDao");
		iUserDao.deleteUser(tmpu);
		String url = response.encodeRedirectURL(request  
                .getContextPath() + "/UserManage.jsp");  
        response.sendRedirect(url); 
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
