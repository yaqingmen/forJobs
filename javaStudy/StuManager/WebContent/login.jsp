<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>欢迎使用东大学生管理系统</h2>
	<form action="LoginServlet" method="post">
		账号:<input type="text" name="username" /><br>
		密码：<input type="text" name="password" /><br>
		<input type="submit" value="登录">
	</form>

</body>
</html>