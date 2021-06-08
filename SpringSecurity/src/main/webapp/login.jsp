<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>
<h1>Login</h1>
${SPRING_SECURITY_LAST_EXCEPTION.message}
<form action="login" method="POST">
<table>
<tr>
<td>UserName:</td>
<td><input type="text" name="username" value=''></td>
</tr>
<tr>
<td>Password:</td>
<td><input type="password" name="password" ></td>
</tr>
<tr>
<td><input type="submit" name="submit" value="submit"></td>
</tr>
</table>

</form>

</body>
</html>