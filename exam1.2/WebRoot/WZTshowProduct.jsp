<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%><%@page import="WZTproduct.wztProduct"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'WZTshowProduct.jsp' starting page</title>
    
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
    This is WZTshowProduct page. <br>
    
    		<br>
		<br>
<%wztProduct WZTP=(wztProduct)session.getAttribute("wztProduct"); %>
		产品名称:<%=WZTP.getWZTname() %><br>
		<br>
		产品型号:<%=WZTP.getWZTxinghao() %><br>
		<br>
		厂商:<%=WZTP.getWZTchangshang() %><br>
		<br>
  </body>
</html>
