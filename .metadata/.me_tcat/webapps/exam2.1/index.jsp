<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
    This is my JSP page. <br>
        <form action="servlet/wztProduct" method="post">
    	产品名称:<input type="text" name="WZTname"><br><br>
    	产品型号:<input type="text" name="WZTxinghao"><br><br>
    	厂商:<input type="text" name="WZTchangshang"><br><br>
    	<input type="submit" value="wzt提交">
    </form>
    <form action="servlet/wztProduct" method="get">
    <input type="submit" value="wzt查询所有产品">
    </form>
  </body>
</html>
