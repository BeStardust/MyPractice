
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>


<!DOCTYPE html>
<%

%>
<html>

	<head>
	
		<title>jsp</title>
	</head>
	<body>
		<form action="servlet/testLogin" method="post">
			姓名：
			<input type="text" name="name" value="">
			<br>
			<br>
			<input type="submit" value="登录">
		</form>
		<form action="servlet/testLogin" method="get">
			姓名：
			<input type="text" name="name" value="">
			<br>
			<br>
			<input type="submit" value="注册">
		</form>
	</body>
</html>