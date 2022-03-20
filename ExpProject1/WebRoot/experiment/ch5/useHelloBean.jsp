<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="ch5.Hello"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setCharacterEncoding("UTF-8");
//String name = request.getParameter("hello");

%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'useHelloBean.jsp' starting page</title>
    
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
 <jsp:useBean id="h" class="ch5.Hello" scope="session"/>
 	<jsp:setProperty name="h" property="*" />
 
   你好：<jsp:getProperty name="h" property="hello" /><br>

  </body>
</html>
