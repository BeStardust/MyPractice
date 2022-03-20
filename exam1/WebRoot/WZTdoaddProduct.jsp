<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'WZTdoaddProduct.jsp' starting page</title>

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
		This is WZTdoaddProduct JSP page.
		<br>
		<br>
		<jsp:useBean id="wztProduct" class="wztBean.wztProduct"
			scope="session">
			<jsp:setProperty name="wztProduct" property="WZTname" />
			<jsp:setProperty name="wztProduct" property="WZTxinghao" />
			<jsp:setProperty name="wztProduct" property="WZTchangshang" />
		</jsp:useBean>
		产品名称:<jsp:getProperty name="wztProduct" property="WZTname" /><br>
		<br>
		产品型号:<jsp:getProperty name="wztProduct" property="WZTxinghao" /><br>
		<br>
		厂商:<jsp:getProperty name="wztProduct" property="WZTchangshang" /><br>
		<br>
	</body>
</html>
