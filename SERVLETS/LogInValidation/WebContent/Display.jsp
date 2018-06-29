<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Display</title>
</head>
<body bgcolor="aqua">
	<h1>Welcome To BridgeLabz</h1>
	<%
	Cookie ck[] = request.getCookies();
	PrintWriter output = response.getWriter();
	%>
	Hii <%= ck[0].getValue()%> , Welcome To My Company			

</body>
</html>