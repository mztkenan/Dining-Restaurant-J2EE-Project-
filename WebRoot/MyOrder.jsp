<%@page import="java.security.Principal"%>
<%@page import="com.cugb.javaee.dao.IOrderInfomationDao"%>
<%@page import="com.cugb.javaee.bean.OrderInfomation"%>
<%@page import="com.cugb.javaee.utils.PageModel"%>
<%@page import="com.cugb.javaee.biz.ProductService"%>
<%@page import="com.cugb.javaee.dao.IProductDao"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查看订单信息</title>
<script type="text/javascript" src="js/myorder.js"></script>
<link rel="stylesheet" type="text/css" href="css/myorder.css"/>
</head>
<body>    
	<div id="content">
		<div id="body">
			<ul>
                <li class="id">订单编号</li>
                <li class="name">送货地址</li>
                <li class="date">下单时间</li>
                <li class="price">订单总额</li>
                <li class="status">订单状态</li>
			</ul>
			<div id="goodlist">
				<%
					if(session.getAttribute("user")==null){
		            	request.setAttribute("wrongMessage", "您未登录");
		            	request.setAttribute("target", "Menu.jsp");
		            	request.getRequestDispatcher("WrongMessage.jsp").forward(request, response);
		            	return;
					}
					User user=(User)session.getAttribute("user");
					String uid=user.getUserId();
					IOrderInfomationDao iDao=(IOrderInfomationDao)DaoFactory.newInstance("IOrderInfomationDao");
					ArrayList<OrderInfomation> list = (ArrayList<OrderInfomation>) iDao.findOrderInfomationsForUser(uid);
					if (list != null) {
						for (int i = 0; i < list.size(); i++) {
							OrderInfomation order= list.get(i);			
				%>
				<div class="goodinfo" id="gooddiv<%=i + 1%>">
					<span class="orderid"><p><%=order.getOrderId()%></p></span> 
					<span class="ordername"><%=order.getOrderAddress()%></span> 
					<span class="orderdate"><%=order.getOrderDate()%></span>
					<span class="orderprice"> <%=order.getOrderPrice()%></span>
					<span class="orderstatus"> <%=order.getOrderState()%></span>
				</div>
				<%
					}
					}
				%>
			</div>

		</div>
	</div>
</body>
</html>