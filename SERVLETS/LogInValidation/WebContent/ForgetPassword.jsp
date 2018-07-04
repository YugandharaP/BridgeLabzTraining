<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ForgetPassword</title>
</head>
<body bgcolor="aqua"><form action="sendEmail" method ="post">
	<div style="background-color: pink">
		<fieldset>
			<legend>
				<h3 style="color: yellow;">Forget Password</h3>
			</legend>
			<h3>Get A Verification Code</h3>
			<h5>Our Application will send a verification code to you email</h5>
			<h3>
				Enter Email : <input type="email" name="email" required placeholder="abc@mail.com">
				<input type="submit" value="Send"/>
			</h3>
		</fieldset>
	</div>
</body>
</html>