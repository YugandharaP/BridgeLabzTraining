<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FilterSignUpFailed</title>
</head>
<body bgcolor="aqua">
	<h3>${message}</h3>
</body>
</html>
<%
	request.getRequestDispatcher("SignUp.jsp").include(request, response);
%>

