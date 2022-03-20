<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
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

		<title>My JSP 'show.jsp' starting page</title>

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
		This is show page.
		<br>
		<br>
		<%
			request.setCharacterEncoding("utf-8");
			session.setAttribute("goodsname", request.getParameter("goodsname"));
			//			response.setContentType("text/html;charset=utf-8");
			//		response.setCharacterEncoding("utf-8");
			//	request.setCharacterEncoding("utf-8");
			//		session.setAttribute("goodsname",request.getParameter("goodsname"));
			session.setAttribute("number", request.getParameter("number"));
			session.setAttribute("price", request.getParameter("price"));
		%>
		<table border="1px" width="400px">
			<tr align="center">
				<th colspan="2">
					<%=session.getAttribute("name")%>
				</th>
			</tr>
			<tr align="center">
				<td>
					商品名
				</td>
				<td>
					<%=session.getAttribute("goodsname")%>
				</td>
			</tr>
			<tr align="center">
				<td>
					数量
				</td>
				<td>
					<%=session.getAttribute("number")%>
				</td>
			</tr>
			<tr align="center">
				<td>
					单价
				</td>
				<td>
					<%=session.getAttribute("price")%>元
				</td>
			</tr>

		</table>
	</body>
</html>
