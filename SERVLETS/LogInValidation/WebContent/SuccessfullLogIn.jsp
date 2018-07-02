
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SuccessFullLogIn</title>
</head>
<style>
div.ex {
	text-align: right width:300px;
	padding: 10px;
	margin: 0px
}
</style>
<body bgcolor="aqua">
	<center>
		<h3>${message}</h3>
		<h1>Welcome To BridgeLabz</h1>
		<div class="ex">
			<table style="width: 60%" border=1>
				<tr>
					<td>SerialNum</td>
					<td>FullName</td>
					<td>MobileNumber</td>
					<td>EmailId</td>
				</tr>

				<tr>
					<td><h4>${serialNum}</h4></td>
					<td><h4>${fullName}</h4></td>
					<td><h4>${mobile}</h4></td>
					<td><h4>${username}</h4></td>
				</tr>
			</table>
		</div>
		<br>
		<br>
		<form action="LogoutSuccess" method="get">
			<input type="submit" value="LogOut" name="LogOut">
		</form>
		
	</center>
</body>
</html>




