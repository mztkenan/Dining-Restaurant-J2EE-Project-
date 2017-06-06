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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
						<TABLE cellSpacing=2 cellPadding=1 width="100%" align=center
							border=0>
							<TBODY>
							<% 
				                
				               ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("ProductList");
				               
				               if(list!=null&&list.size()>0)
				               {
				                for(int i=0;i<list.size();i=i+2)
				                {
				                   Product product1 = list.get(i);
				                   Product product2 = null;
				                   if(i+1<list.size()){
				                	   product2=list.get(i+1);
				                   }
				           %>   
								<tr>
									<TD >
									<TABLE height="100%" cellSpacing=1 cellPadding=2 border=0>
										<TBODY>
											<TR>
												<TD vAlign=top width=90 height=90><A href=#
													target=_blank><IMG height=80 alt=点击图片查看内容
													src=<%=product1.getProductImage()%> width=80 border=0></A></TD>
												<TD vAlign=top>
												<TABLE cellSpacing=1 cellPadding=0 width="100%" align=center
													border=0>
													<TBODY>
														<TR>
															<TD><A href=# target=_blank><STRONG><%=product1.getProductName()%></STRONG></A></TD>
														</TR>
														<TR>
															<TD height=21><FONT color=#ff0000>现价：人民币<%=product1.getProductPrice()%>元</FONT><BR>
															<%=product1.getProductDescription()%></TD>
														</TR>
													</TBODY>
												</TABLE>
												</TD>
											</TR>
											<TR>
												<TD height=28>编号: <%=product1.getProductId()%></TD>
												<TD>
												<TABLE cellSpacing=1 cellPadding=0 width=145 border=0>
													<TBODY>
														<TR>
															<TD align="middle" width="70"><a href="#">
                                                            <img
																src="images/buy_cn.gif" border="0"
																longdesc="shoppingCart.html" width="60" height="20"></a></TD>
															<TD align=middle width=70><A href=# target=_blank>
                                                            <IMG
																src="images/detail_cn.gif" border=0 width="60" height="20"></A></TD>
														</TR>
													</TBODY>
												</TABLE>
												</TD>
											</TR>
										</TBODY>
									</TABLE>
									</TD>
									<%
										if(product2!=null){
									%>
									<TD>
									<TABLE height="100%" cellSpacing=1 cellPadding=2 border=0>
										<TBODY>
											<TR>
												<TD vAlign=top width=90 height=90><A href=#
													target=_blank><IMG height=80 alt=点击图片查看内容
													src=<%=product2.getProductImage()%> width=80 border=0></A></TD>
												<TD vAlign=top>
												<TABLE cellSpacing=1 cellPadding=0 width="100%" align=center
													border=0>
													<TBODY>
														<TR>
															<TD><A href=# target=_blank><STRONG><%=product2.getProductName() %></STRONG></A></TD>
														</TR>
														<TR>
															<TD height=21><FONT color=#ff0000>现价：人民币<%=product2.getProductPrice() %>元</FONT><BR>
															<%=product2.getProductDescription() %></TD>
														</TR>
													</TBODY>
												</TABLE>
												</TD>
											</TR>
											<TR>
												<TD height=28>编号: <%=product2.getProductId() %></TD>
												<TD>
												<TABLE cellSpacing=1 cellPadding=0 width=145 border=0>
													<TBODY>
														<TR>
															<TD align=middle width=70><A href=#>
                                                            <IMG
																src="images/buy_cn.gif" border=0 width="60" height="20"></A></TD>
															<TD align=middle width=70><A href=# target=_blank>
                                                            <IMG
																src="images/detail_cn.gif" border=0 width="60" height="20"></A></TD>
														</TR>
													</TBODY>
												</TABLE>
												</TD>
											</TR>
										</TBODY>
									</TABLE>
									</TD>
									<%
										}
									%>
								</tr>
						   <%
				                }
				               } 
				           %>
				           <tr>
									<td  height="2">
										<div align="left">
											<font color="#000000">&nbsp;共&nbsp${requestScope.pageModel.totalPages}&nbsp页</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<font color="#000000">当前第</font>&nbsp
											<font color="#000000">${requestScope.pageModel.currentPage}</font>&nbsp
											<font color="#000000">页</font>
										</div>
									</td>
									<td  >
										<div align="right">
											<a name="btnTopPage"  id="btnTopPage" href="PageListControl?actiontype=pagelist&currentPageNum=1" title="首页">|&lt;&lt; </a>&nbsp;
											<a name="btnPreviousPage"  id="btnPreviousPage" href="PageListControl?actiontype=pagelist&currentPageNum=${requestScope.pageModel.prevPageNO}" title="上页"> &lt;  </a>&nbsp;
											<a name="btnNextPage"  id="btnNextPage" href="PageListControl?actiontype=pagelist&currentPageNum=${requestScope.pageModel.nextPageNO}" title="下页">  &gt; </a>&nbsp;
											<a name="btnBottomPage"  id="btnBottomPage" href="PageListControl?actiontype=pagelist&currentPageNum=${requestScope.pageModel.bottomPageNO}" title="尾页"> &gt;&gt;|</a>
											
										</div>
									</td>
								</tr>
							</TBODY>
						</TABLE>
</body>
</html>