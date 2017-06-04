<%@page import="com.cugb.javaee.biz.ProductService"%>
<%@page import="com.cugb.javaee.utils.PageModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.cugb.javaee.dao.ProductDaoImpl"%>
<%@page import="com.cugb.javaee.bean.Product"%>
<%@page import="java.awt.event.ItemEvent"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" mrc="text/html; charset=gb2312" />
<title>分页</title>
<link href="css/ListView.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
<%
	if(request.getParameter("currentPageNum")==null){
		ProductService iProductService=new ProductService();
		PageModel pagemodel=iProductService.showPagelist(1, 6);
		request.setAttribute("ProductList", pagemodel.getList());
		request.setAttribute("pageModel", pagemodel); 
	}

%>
<!-- menu -->
	<div class="menu-page">
		<div class="container">
			<div class="menu-title">
				<h3>  菜 单    </h3>
				<div class="line">
				</div>
				<p class="proident">在这里，遇见最美的食物</p>
			</div>
							<% 
				                
				               ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("ProductList");
				               
				               
				               if(list!=null&&list.size()>0)
				               {
				            	   
				                for(int i=0;i<Math.ceil(list.size()/3.0);i++)
				                {
				                   Product product1 = list.get(3*i);
				                   Product product2 = null;
				                   Product product3 = null;
				                   if(3*i+1<list.size()){
				                	   product2=list.get(3*i+1);
				                   }
				                   
				                   if(3*i+2<list.size()){
				                	   product3=list.get(3*i+2);
				                   }
				                   
				           %> 
			<div class="menu-page-grids">
				<div class="col-md-4 menu-grids-info">
					<img src="<%=product1.getProductImage()%>" alt="" title=""/>
					<h4><a href="#"><%=product1.getProductName()%></a></h4>
					<p><%=product1.getProductDescription()%></p>
					<div class="menu-rate">
						<h5>￥<%=product1.getProductPrice()%></h5>
						<h5><a color="#f1e1c1" href="AddItems?PID=<%=product1.getProductId()%>&PNumber=1">购买</a></h5>
					</div>
				</div>
				<%if(product2!=null) {%>
				<div class="col-md-4 menu-grids-info">
					<img src="<%=product2.getProductImage()%>" alt="" title=""/>
					<h4><a href="#"><%=product2.getProductName()%></a></h4>
					<p><%=product2.getProductDescription()%></p>
					<div class="menu-rate">
						<h5>$<%=product2.getProductPrice()%></h5>
						<h5><a href="AddItems?PID=<%=product2.getProductId()%>&PNumber=1">购买</a></h5>
					</div>
				</div>
				<%} %>
				<%if(product3!=null) {%>				
				<div class="col-md-4 menu-grids-info">
					<img src="<%=product3.getProductImage()%>" alt="" title=""/>
					<h4><a href="#"><%=product3.getProductName()%></a></h4>
					<p><%=product3.getProductDescription()%></p>
					<div class="menu-rate">
						<h5>$<%=product3.getProductPrice()%></h5>
						<h5><a href="AddItems?PID=<%=product3.getProductId()%>&PNumber=1">购买</a></h5>
					</div>
				</div>
				<%} %>				
				<div class="clearfix"> </div>
			</div>
		<%
	 		 }
			} 
		 %>
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
				  <li class="firstPage currentState"><a href="PageListControl?actiontype=pagelist&currentPageNum=1" title="首页">首页</a></li>
				  <li class="previousPage currentState"><a href="PageListControl?actiontype=pagelist&currentPageNum=${requestScope.pageModel.prevPageNO}" title="前一页">前一页</a></li>
				
				  <li class="nextPage"><a href="PageListControl?actiontype=pagelist&currentPageNum=${requestScope.pageModel.nextPageNO}" title="后一页">后一页</a></li>
				  <li class="lastPage"><a href="PageListControl?actiontype=pagelist&currentPageNum=${requestScope.pageModel.bottomPageNO}" title="尾页">尾页</a></i>
				</ul>
			</td>
		</tr>
		</tbody>
		</table>

		</div>
	</div>

</body>
</html>