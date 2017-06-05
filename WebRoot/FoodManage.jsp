<%@page import="com.cugb.javaee.action.PageListControl"%>
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
<title>食品管理界面</title>
<link rel="stylesheet" type="text/css" href="css/FoodManage.css" />
<link rel="stylesheet" type="text/css" href="css/ListView.css" />
<!-- js -->
<script language="javascript" type="text/javascript" src="js/ShopCart.js"></script>
<!-- //js -->

</head>

<body>


	<div id="content">
		<div id="body">
			<ul>
                <li class="id">编号</li>
                <li class="name">商品名称</li>
                <li class="lowprice">价格</li>
                <li class="quantity">库存</li>
                <li class="operate">操作</li>
			</ul>
			<div id="goodlist">
				<%
					int pageSize=PageListControl.loadPageSize("FoodManagePageSize");
					
					if(request.getParameter("currentPageNum")==null){
						ProductService iProductService=new ProductService();
						PageModel pagemodel=iProductService.showPagelist(1, pageSize);
						request.setAttribute("ProductList", pagemodel.getList());
						request.setAttribute("pageModel", pagemodel); 
					}					
				
				ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("ProductList");
					if (list != null) {
						int row = list.size();
						for (int i = 0; i < list.size(); i++) {
							Product pro = list.get(i);
				%>
				<div class="goodinfo" id="gooddiv<%=i + 1%>">
					<span class="productid"><p><%=pro.getProductId()%></p></span> 
					<span class="productname"><%=pro.getProductName()%></span> 
					<span class="productprice"><%=pro.getProductPrice()%></span>
					<span class="quantity"> <%=pro.getProductRemained() %></span>
		
					<span class="caozuo"> 
					<a href="#"	onclick="sahngchu2(<%=pro.getProductId()%>);">删除</a>
					<a href="#"	onclick="update(<%=pro.getProductId()%>)">更新</a>
					</span>
				</div>
				<%
					}
					}
				%>
			</div>

		</div>
		<br>
		<table cellSpacing=2 cellPadding=1 width="100%" align=center border=0>
		<tbody>
		<tr>
			<td>
			<ul class="pagination" title="分页列表">
				<div align="left">
					  <li class="totalPage">总页数：<i>${requestScope.pageModel.totalPages}</i></li>
					<li class="currentPage">当前页：<b>${requestScope.pageModel.currentPage}</b></li>
				</div>
			</ul>
			</td>
			<td>
				<ul align="right" class="pagination" title="分页列表">
				  <li class="firstPage currentState"><a href="PageListControl?actiontype=pagelist&currentPageNum=1&target=FoodManage.jsp&property=FoodManagePageSize" title="首页">首页</a></li>
				  <li class="previousPage currentState"><a href="PageListControl?actiontype=pagelist&currentPageNum=${requestScope.pageModel.prevPageNO}&target=FoodManage.jsp&property=FoodManagePageSize" title="前一页">前一页</a></li>
				
				  <li class="nextPage"><a href="PageListControl?actiontype=pagelist&currentPageNum=${requestScope.pageModel.nextPageNO}&target=FoodManage.jsp&property=FoodManagePageSize" title="后一页">后一页</a></li>
				  <li class="lastPage"><a href="PageListControl?actiontype=pagelist&currentPageNum=${requestScope.pageModel.bottomPageNO}&target=FoodManage.jsp&property=FoodManagePageSize" title="尾页">尾页</a></i>
				</ul>
			</td>
		</tr>
		</tbody>
		</table>
		
	</div>
</body>
</html>