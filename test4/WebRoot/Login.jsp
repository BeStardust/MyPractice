<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
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
			<div style="margin-left: 40%; margin-right: 40%; margin-top: 25px">
				<form action="servlet/LoginServlet" method="post">
					<div>
						<div style="float: left">
							USERNAME
						</div>
						<div style="float: right">
							<input type="text" name="username" value="<%=username%>">
						</div>
					</div>
					<br>
					<br>
					<div>
						<div style="float: left">
							PASSWORD
						</div>
						<div style="float: right">
							<input type="password" name="password" value="<%=password%>">
						</div>
					</div>
					<br>
					<br>
					<div>
						<input  type="checkbox" name="remember" value="yes" checked="checked">
						记住用户名和密码
					</div>
						<input type="checkbox" name="remember" value="yes"
							checked="checked">
						记住用户名和密码
					</div>
					<br>
					<div style="text-align: center">
						<input type="submit" value="登录">
					</div>
					<br>

				</form>
			</div>
		
    <%
        //判读是否为第一次启动，如果启动则添加属性
        if((Integer) application.getAttribute("AccessCount") == 0){
            application.setAttribute("AccessCount", 0);
        }
        //获得访问次数
        int count = (Integer) application.getAttribute("AccessCount");
        //访问次数加一
        application.setAttribute("AccessCount", count+=1);
    %>
    <h3 align="center">当前访问人数：<%=count%></h3>


	</body>
</html>
