<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SignIn</title>
</head>
<body bgcolor="lightblue">
	<div style="background-color: pink">
		<form action="signin" method="post">
			<fieldset>
				<legend>
					<h3 style="color: yellow;">SignIn</h3>
				</legend>
				UserName : <input type="email" name="username">&nbsp;&nbsp;
				Password : <input type="password" name="password"
					pattern="((?=.*\d)(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[@#$%^&*()!]).{6,20})"
					title="must Contain atleast( one digit[0-9],one aplha[a-z] and [A-Z],one specialCharacter )">
				<h4>
					<input type="submit" value="signIn" />&nbsp;
				</h4>
				<h4>
					<a href="ForgetPassword.html">Forget password</a>
				</h4>
			</fieldset>
		</form>
	</div>
</body>
</html>