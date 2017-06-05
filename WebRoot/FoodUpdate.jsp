<%@page import="com.cugb.javaee.utils.PageModel"%>
<%@page import="com.cugb.javaee.biz.ProductService"%>
<%@page import="com.cugb.javaee.dao.IProductDao"%>
<%@page import="com.cugb.javaee.bean.User"%>
<%@page import="com.cugb.javaee.utils.DaoFactory"%>
<%@page import="com.cugb.javaee.dao.IUserDao"%>
<%@page import="com.cugb.javaee.bean.Product"%>
<%@page import="com.cugb.javaee.bean.CartItem"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更改商品信息</title>
<link rel="stylesheet" type="text/css" href="css/FoodUpdate.css?v=1.5" />
</head>
<body>
<div id="content">
<div id="body">
			<%	
				String pid=request.getParameter("PID");
					if(pid==null){
						request.setAttribute("wrongMessage", "您没选择任何需要更改的餐品");
						request.setAttribute("target", "FoodManage.jsp");
						request.getRequestDispatcher("WrongMessage.jsp").forward(request, response);
						return;
					}
				IProductDao iDao=(IProductDao)DaoFactory.newInstance("IProductDao");
				Product pro =iDao.findProduct(pid);
				%>
			<div id="goodlist">
			<div class="goodinfo" id="gooddiv1">
               	
                
                
                
                
                
			</div>
			</div>
		</div>
			<TABLE cellSpacing=0 cellPadding=0 width=100% border=0>
				<TBODY>
					<TR>
						<TD>商品名称: </TD><TD><input type="text" name="ProductName" placeholder="<%=pro.getProductName()%>" ></TD>
					</TR>
					<TR>
						<TD>价格:</TD><TD><input type="text" name="ProductName" placeholder="<%=pro.getProductPrice()%>" ></TD>
					</TR>
					<TR>
						<TD >库存:</TD><TD valign="top"><input type="text" name="ProductName" placeholder="<%=pro.getProductRemained() %>" ></TD>
					</TR>
					<TR>
						<TD style="vertical-align:top">描述:</TD><TD ><input style="height:140px;vertical-align:top" type="text" name="ProductName" placeholder="<%=pro.getProductDescription() %>" ></TD>
					</TR>						
					<TR>
						<TD>图片:</TD><TD><input type="text" name="ProductName" placeholder="<%=pro.getProductImage()%>" ></TD>
					</TR>
					<TR>
						<TD></TD><TD><input type="text" name="submmit" value="确认提交" action=""></TD>
					</TR>										
				</TBODY>
			</TABLE>
			<br>
			<br>
			<div class="ImageShow"><img alt="商品图片" src="<%=pro.getProductImage()%>"></div>
</div>
</body>
</html>