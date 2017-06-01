<%@page import="java.util.ArrayList"%>
<%@page import="com.cugb.javaee.dao.ProductDaoImpl"%>
<%@page import="com.cugb.javaee.bean.Product"%>
<%@page import="java.awt.event.ItemEvent"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    This is my JSP page. <br>
    
  <form action="_do" method="get">
	  <p>UserName: <input type="text" name="loginname" /></p>
	  <p>PassWord: <input type="text" name="loginpassword" /></p>
	  <input type="submit" value="Submit" />
  </form>
   <form action="_do2" method="get">
	  <input type="submit" value="SignOut" />
  </form>
  </body>
</html>