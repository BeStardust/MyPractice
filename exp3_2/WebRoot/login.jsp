<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'index.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>

	<body>


		<form action="servlet/UserServlet" method="post">

			<table style="text-align: center; width: 300px">
				<tr>
					<td colspan="2">
						This is login page.<br><br>
					</td>
				</tr>
				<tr>
					<td>
						用户名：<br><br>
					</td>
					<td>
						<input type="text" name="name" value=""><br><br>
					</td>
				</tr>
				<tr>
					<td>
						密       码：<br><br>
					</td>
					<td>
						<input type="password" name="password" value=""><br><br>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="登录"><br><br>

					</td>
				</tr>
				<tr>
					<td colspan="2">
						没有账户？点击
						<a href="register.jsp">注册</a>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
