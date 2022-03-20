
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%><%@page
	import="java.io.PrintWriter"%>

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

		<title>My JSP 'GoodsInput.jsp' starting page</title>

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
		<br>
		This is GoodsInput page.
		<br>
		<br>

		<%
		request.setCharacterEncoding("utf-8");
			String username = request.getParameter("username");
					
			if (username.equals("") || username == null) {
				//	PrintWriter out1=response.getWriter();
				out.println("姓名不能为空！<br>3秒后跳转回首页！");
				response.setHeader("Refresh", "3;URL=" + path
						+ "/UserInput.jsp");
			} else {
//				HttpSession session=request.getSession();
				session.setAttribute("name",username);
				out.println("欢迎您，" + session.getAttribute("name") + " 先生/女士");
			}
		%>

		<!--     欢迎您，<%=username%>先生/女士-->
		<br>
		<br>
		<form action="show.jsp" method="post">
		商品名
		<input type="text" name="goodsname">
		<br>
		<br>
		数量&nbsp;&nbsp;&nbsp;
		<input type="text" name="number">
		<br>
		<br>
		单价&nbsp;&nbsp;&nbsp;
		<input type="text" name="price">元
		<br>
		<br>
		<input type="submit" value="提交">
		</form>

	</body>
</html>
