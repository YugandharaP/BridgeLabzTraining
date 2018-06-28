<%@page import="com.bridgelabz.serviceimplementation.DataAccessObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String username = (String) request.getAttribute("username");
	String password = (String) request.getAttribute("password");
	DataAccessObject object = new DataAccessObject();
	object.connectionPoolFactory();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ResultPage</title>
</head>
<body bgcolor="aqua">
	<h1>Welcome To BridgeLabz</h1>
	<table border="1">
		<tr>
			<td>SerialNo</td>
			<td>FullName</td>
			<td>MobileNo</td>
			<td>Email</td>
			<td>Password</td>
		</tr>
		<%
			String select = "select * from Students where Email = '" + username + "' and Password = '" + password+"'";
			object.pst = object.con.prepareStatement(select);
			object.res = object.pst.executeQuery();
			while (object.res.next()) {
		%>
		<tr><h3>Hii <%=object.res.getString(2)%> , your details are here :</h1>
			<td><%=object.res.getInt(1)%></td>
			<td><%=object.res.getString(2)%></td>
			<td><%=object.res.getLong(3) %>
			<td><%=object.res.getString(4)%></td>
			<td><%=object.res.getString(5)%></td>
		</tr>
		<%
			}
			object.closeCostlyConnections();
		%>
	</table>
</body>
</html>


