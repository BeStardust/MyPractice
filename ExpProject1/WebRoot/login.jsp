<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="errors/error.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<%--在下面添加JSP代码，处理从index.jsp提交过来的数据，数据包括用户名与密码；
	1、如果用户名或密码为空，抛出“用户名或密码为空的异常”，并交给errors/error.jsp
	页面处理；
	2、如果用户名与密码都不为空，在session对象中设置属性（Attribute），属性
	名为user，属性值为用户提交的用户名，并跳转到index.jsp页面。
--%>


<%	
	request.setCharacterEncoding("UTF-8");
	String user = request.getParameter("userName");
	String pwd = request.getParameter("pwd");
	if(user == null || user.trim().length()==0 || pwd == null || pwd.trim().length()==0){
		throw new Exception("用户名或密码为空");
	}
	else{
		session.setAttribute("user",user);
		response.setHeader("refresh","1;URL=index.jsp");
	}
	%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Login.jsp</title>
    
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
 登录成功，页面跳转中......
  </body>
</html>
