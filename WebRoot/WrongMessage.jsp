<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
	String message,target="Menu.jsp";
	if(request.getAttribute("target")!=null){
		target=(String)request.getAttribute("target");
		request.removeAttribute("target");
		
	}
			if(request.getAttribute("wrongMessage")!=null){
				message=(String)request.getAttribute("wrongMessage");
				request.removeAttribute("wrongMessage");
		%>
		<script type="text/javascript">
			alert("<%=message%>");
			window.location.href="<%=target%>";
		</script>
 <% 		
			}
 %>
</body>
</html>