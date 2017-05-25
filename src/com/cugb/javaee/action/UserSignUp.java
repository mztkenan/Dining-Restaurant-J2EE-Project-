package com.cugb.javaee.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.cugb.javaee.bean.User;
import com.cugb.javaee.dao.IUserDao;
import com.cugb.javaee.utils.DaoFactory;

public class UserSignUp extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		String passWord2 = request.getParameter("passWord2");
		//用户注册
		if(true){
			//判断用户名是否合法
			JOptionPane.showMessageDialog(null, "用户名不合法或者已经被注册", "注意", JOptionPane.ERROR_MESSAGE);   
		}
		else if(!passWord.equals(passWord2)){
			//两次密码是否相同并合法
			JOptionPane.showMessageDialog(null, "两次密码不一致", "注意", JOptionPane.ERROR_MESSAGE);   
		}
		else{
			//插入用户数据，对话框显示成功消息
			IUserDao iUserDao = (IUserDao) DaoFactory.newInstance("IUserDao");
			User user = new User("0",userName,passWord,1);
			user.setUserId(Integer.toString(iUserDao.countRows()));
			iUserDao.insertUser(user);
			//跳转欢迎界面
			String url = response.encodeRedirectURL(request.getContextPath() + "/index.jsp");  
	        response.sendRedirect(url);  
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
