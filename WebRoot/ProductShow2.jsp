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
<title>CSS实现的一个漂亮分页按钮样式</title>
<style type="text/css">
.pagination{
 overflow:hidden;
 margin:0;
 padding:10px 10px 6px 10px;
 border-top:1px solid #f60;
 _zoom:1;
}
.pagination *{
 display:inline;
 float:left;
 margin:0;
 padding:0;
 font-size:12px;
}
.pagination i{
 float:none;
 padding-right:1px;
}
.currentPage b{
 float:none;
 color:#f00;
}
.pagination li{
 list-style:none;
 margin:0 5px;
}
.pagination li li{
 position:relative;
 margin:-2px 0 0;
 font-family: Arial, Helvetica, sans-serif
}
.firstPage a,.previousPage a,.nextPage a,.lastPage a{
 overflow:hidden;
 height:0;
 text-indent:-9999em;
 border-top:8px solid #fff;
 border-bottom:8px solid #fff;
}
.pagination li li a{
 margin:0 1px;
 padding:0 4px;
 border:3px double #fff;
 +border-color:#eee;
 background:#eee;
 color:#06f;
 text-decoration:none;
}
.pagination li li a:hover{
 background:#f60;
 border-color:#fff;
 +border-color:#f60;
 color:#fff;
}
li.firstPage{
 margin-left:40px;
 border-left:3px solid #06f;
}
.firstPage a,.previousPage a{
 border-right:12px solid #06f;
}
.firstPage a:hover,.previousPage a:hover{
 border-right-color: #f60;
}
.nextPage a,.lastPage a{
 border-left:12px solid #06f;
}
.nextPage a:hover,.lastPage a:hover{
 border-left-color:#f60;
}
li.lastPage{
 border-right:3px solid #06f;
}
li li.currentState a{
 position:relative;
 margin:-1px 3px;
 padding:1px 4px;
 border:3px double #fff;
 +border-color:#f60;
 background:#f60;
 color:#fff;
}
li.currentState,.currentState a,.currentState a:hover{
 border-color:#fff #ccc;
 cursor:default;
}
</style>
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
				            	   System.out.println(list.size());
				                for(int i=0;i<Math.ceil(list.size()/3.0);i++)
				                {
				                   Product product1 = list.get(3*i);
				                   Product product2 = null;
				                   Product product3 = null;
				                   if(3*i+1<list.size()){
				                	   product2=list.get(3*i+1);
				                   }
				                   System.out.println("A"+3*i);
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
						<h5>$<%=product1.getProductPrice()%></h5>
						<h5><a href="AddItems?PID=<%=product1.getProductId()%>&PNumber=1">购买</a></h5>
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
				<div align="left">
					<font color="#000000">&nbsp;共&nbsp${requestScope.pageModel.totalPages}&nbsp页</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<font color="#000000">当前第</font>&nbsp
					<font color="#000000">${requestScope.pageModel.currentPage}</font>&nbsp
					<font color="#000000">页</font>
				</div>
			</td>
			<td>
				<div align="right">
					<a name="btnTopPage"  id="btnTopPage" href="PageListControl?actiontype=pagelist&currentPageNum=1" title="首页">|&lt;&lt; </a>&nbsp;
					<a name="btnPreviousPage"  id="btnPreviousPage" href="PageListControl?actiontype=pagelist&currentPageNum=${requestScope.pageModel.prevPageNO}" title="上页"> &lt;  </a>&nbsp;
					<a name="btnNextPage"  id="btnNextPage" href="PageListControl?actiontype=pagelist&currentPageNum=${requestScope.pageModel.nextPageNO}" title="下页">  &gt; </a>&nbsp;
					<a name="btnBottomPage"  id="btnBottomPage" href="PageListControl?actiontype=pagelist&currentPageNum=${requestScope.pageModel.bottomPageNO}" title="尾页"> &gt;&gt;|</a>
				</div>
			</td>
		</tr>
		</tbody>
		</table>

		</div>
	</div>


</body>
</html>