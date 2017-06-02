<%@page import="com.cugb.javaee.bean.Product"%>
<%@page import="com.cugb.javaee.bean.CartItem"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>购物车</title>
<link rel="stylesheet" type="text/css" href="css/ShopCar.css"/>
<!-- js -->
<script language="javascript" type="text/javascript" src="js/ShopCar.js"></script>
<!-- //js -->

</head>

<body>


<div id="content">
	<div id="body">
		<div id="tu"></div>
  			<ul>
                <li class="name">商品名称</li>
                <li class="lowprice">价格</li>
                <li class="num">数量</li>
                <li class="operate">操作</li>
            </ul> 
            <div id="goodlist">
            <% ArrayList<CartItem> list= (ArrayList<CartItem> )session.getAttribute("carItemArray");
            if(list!=null)
            	for(int i=0 ; i< list.size() ; i++){
            		CartItem tmp = list.get(i);
            		Product pro=tmp.getDish();
            		int qty=tmp.getQuantity();
            		System.out.println(pro.getProductImage());
            		System.out.println(pro.getProductId());
            	
            %>
            
             <div class="goodinfo" id="gooddiv<%=i%>>" >
             <span class="mingcheng"><a href='#' target="_blank"><div style="width:56px; height:56px; background-color:#99CCFF;"><img style="width:100%; height:100%;" src="<%=pro.getProductImage()%>"/></div></a><p><a href='#' target="_blank"><%=pro.getProductName()%></a></p></span><span class="dijia"><%=pro.getProductPrice() %></span><span class="shuliang"><input type="text" id="maishuliang<%=i%>>" value="1" disabled="disabled"/><a href="#"  onclick="jia(<%=i%>);" class="tiaoshu" id="xiangshang"></a><a href="#" onclick="jian(<%=i%>)" class="tiaoshu" id="xiangxia"></a></span><span class="caozuo"><a href="#" onclick="sahngchu(<%=i%>);">删除</a></span>
			</div>	
			<%
            	}
			%>		
			</div>
			<div id="jiesuan">
        	    <p>商品金额总计:￥&nbsp;</p><br/><input type="text" id="qianshu" value="" />
                <p>
            	    <a href="Menu.jsp" id="jixugouwu" target="_blank">&nbsp;&nbsp;&nbsp;继续购物</a>
                    <a href="OrderInfo.jsp" id="qujiesuan" target="_self"></a>
                </p>
            </div>     
</div>

</body>
</html>