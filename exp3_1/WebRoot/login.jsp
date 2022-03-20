<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@page
	import="javaBean.student"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
%>
<%
	response.setCharacterEncoding("utf-8");
//	request.setCharacterEncoding("utf-8");
/*	String name = new String(request.getParameter("name").getBytes(
			"ISO-8859-1"), "utf-8");*/
			String name=request.getParameter("name");
	String idString = request.getParameter("id");
	int id = Integer.valueOf(idString);
	student s = new student();
	s.setName(name);
	s.setId(id);
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'login.jsp' starting page</title>

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
		方式一：
		<br>
		姓名：
		<%=s.getName()%>
		<br>
		<br>
		学号：
		<%=s.getId()%>
		<br>
		<br>
		<br>

		<jsp:useBean id="student" class="javaBean.student" scope="session"></jsp:useBean>
		<jsp:setProperty property="name" name="student" />
		<jsp:setProperty property="id" name="student" />
		方式二：
		<br>
		姓名：
		<jsp:getProperty property="name" name="student" />
		<br>
		<br>
		学号：
		<jsp:getProperty property="id" name="student" />
		<br>
		<br>
	</body>
</html>
