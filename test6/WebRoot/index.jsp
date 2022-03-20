<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
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
		<%
			String username = "";
			String password = "";
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("username")) {
						username = cookie.getValue();
					}
					if (cookie.getName().equals("password")) {
						password = cookie.getValue();
					}
				}
			}
		%>
		This is my JSP page.
		<br>
		<div style="height: 200px; background-color: #3FA6AE">
			<div style="margin-left: 40%; margin-right: 40%; padding-top: 25px">
				<form action="servlet/LoginServlet" method="post">
					<div>
						<div style="float: left">
							USERNAME
						</div>
						<div style="float: right">
							<input type="text" name="username" value="<%=username%>"
								placeholder="请输入用户名">
						</div>
					</div>
					<br>
					<br>
					<div>
						<div style="float: left">
							PASSWORD
						</div>
						<div style="float: right">
							<input type="password" name="password" value="<%=password%>"
								placeholder="请输入密码">
						</div>
					</div>
					<br>
					<br>
					<div style="text-align: center">
						<input type="checkbox" name="remember" value="yes"
							checked="checked">
						记住用户名和密码
					</div>
					<br>
					<div style="text-align: center;float:left;margin-left:75px">
						<a href="register.jsp"><input type="button" value="注册"></a>
					</div>
					<div style="text-align: center">
						<input type="submit" value="登录">
					</div>

					<br>

				</form>
				<%
				int count=0;
				HttpSession sessionCount
				
				
				%>
				<center>您是第<%=count%>位访客</center>
			</div>
		</div>

	</body>
</html>
