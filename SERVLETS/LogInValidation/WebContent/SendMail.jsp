<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Send Mail</title>
</head>
<body bgcolor="aqua">
	<div style="background-color: pink">
		<fieldset>
			<legend>
				<h3 style="color: yellow;">${sendMessage}</h3>
			</legend>
			 <form action="sendMail" method="post"><input type="submit" value="SigIn" /></form>
		</fieldset>
	</div>


</body>
</html>