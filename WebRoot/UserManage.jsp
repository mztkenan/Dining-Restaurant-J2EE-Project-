<%@page import="com.cugb.javaee.bean.User"%>
<%@page import="com.cugb.javaee.utils.DaoFactory"%>
<%@page import="com.cugb.javaee.dao.IUserDao"%>
<%@page import="com.cugb.javaee.bean.Product"%>
<%@page import="com.cugb.javaee.bean.CartItem"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户管理界面</title>
<link rel="stylesheet" type="text/css" href="css/ShopCar.css" />
<!-- js -->
<script language="javascript" type="text/javascript" src="js/ShopCar.js"></script>
<!-- //js -->

</head>

<body>


	<div id="content">
		<div id="body">
			<ul>
				<li class="name">用户名</li>
				<li class="lowprice">用户ID</li>
				<li class="num">密码</li>
				<li class="operate">操作</li>
			</ul>
			<div id="goodlist">
				<%
					IUserDao iUserDao = (IUserDao) DaoFactory.newInstance("IUserDao");
					ArrayList<User> list = (ArrayList<User>) iUserDao.findUsers();
					if (list != null) {
						int row = list.size();
						for (int i = 0; i < list.size(); i++) {
							User user = list.get(i);
				%>
				<div class="goodinfo" id="gooddiv<%=i + 1%>">
					<span class="mingcheng"><p><%=user.getUsername()%></p></span> 
					<span class="dijia"><%=user.getUserId()%></span> 
					<span class="shuliang"><%=user.getPassword()%></span>
					<span class="caozuo"> 
					<a href="#"	onclick="sahngchu2(<%=user.getUserId()%>);">删除</a>
					</span>
				</div>
				<%
					}
					}
				%>
			</div>

		</div>
</body>
</html>