<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" import="java.util.Enumeration"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'getWebXMLInfo.jsp' starting page</title>
    
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
  		Enumeration e = application.getInitParameterNames();
  		while(e.hasMoreElements()){
  			String n = (String)e.nextElement();
  			String v = application.getInitParameter(n);
  			out.println("参数名为"+n+"，参数值为："+v);
  		}
  %>
  </body>
</html>
