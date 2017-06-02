package com.cugb.javaee.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cugb.javaee.bean.User;
import com.cugb.javaee.dao.IUserDao;
import com.cugb.javaee.utils.DaoFactory;

public class UserLogIn extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String loginname = request.getParameter("loginname");  
		String loginpassword = request.getParameter("loginpassword");
		//此处需要访问数据库，判断用户名和密码是否正确	
		IUserDao iUserDao = (IUserDao) DaoFactory.newInstance("IUserDao");
		User user = new User();
		user.setUsername(loginname);
		if(iUserDao.login(user,loginpassword)){		
	    	HttpSession session = request.getSession();  
            // 手动设置session的有效期为30分钟  
            String sessionId = session.getId();  
            Cookie cookie = new Cookie("JSESSIONID", sessionId);  
            cookie.setMaxAge(60 * 30);//单位是秒  
            cookie.setPath(request.getContextPath());  
            response.addCookie(cookie);  
            // 登录成功后要存入用户的登录状态，key是用户对象的String形式,
            //value就是用户对象(model)！！别的页面应该能用到  
            session.setAttribute("user", user);
            // 重定向到首页，URL重写方式  
            String url = response.encodeRedirectURL(request  
                    .getContextPath() + "/Menu.jsp");  
            response.sendRedirect(url);  
            return;  
	    }else{
	    	 response.setCharacterEncoding("UTF-8");  
	         response.setHeader("Content-type", "text/html;charset=UTF-8");  
	         PrintWriter out = response.getWriter();  
	         out.print("用户名或密码错误");  
	    }
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//super.doPost(req, resp);
		doGet(req,resp);
	}

}
