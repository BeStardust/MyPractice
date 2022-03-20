<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

		<title>My JSP 'register.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">


	</head>

	<body>
		This is register page.
		<br>
		<div style="height: 220px; background-color: #3FA6AE">
			<div style="margin-left: 41%; margin-right: 41%;padding-top:20px">
				<form action="servlet/RegisterServlet" method="post">
					<div>
						<div style="float: left">
							USERNAME
						</div>
						<div style="float: right">
							<input type="text" name="username">
						</div>
					</div>
					<br>
					<br>
					<div>
						<div style="float: left">
							PASSWORD
						</div>
						<div style="float: right">
							<input type="password" name="password">
						</div>
					</div>
					<br>
					<br>
										<div>
						<div style="float: left">
							CONFIRM
						</div>
						<div style="float: right">
							<input type="password" name="passwordConfirm">
						</div>
					</div>
					<br>
					<br>
					<input type="checkbox" name="accept" value="yes" checked="checked"
						style="margin-left: 35px">
					我已阅读并接受用户协议
					<br>
					<br>
					<div style="text-align: center">
						<input type="submit" value="注册" style="color: white;background:DodgerBlue">
					</div>
					<br>
				</form>
			</div>
		</div>
	</body>
</html>
