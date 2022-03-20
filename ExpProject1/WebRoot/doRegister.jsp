<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" errorPage="errors/error.jsp"%>

<%-- 使用定义好的数据Bean——User
	1、使用<jsp:useBean>动作创建User的实例对象；
	2、用<jsp:setProperty>获取从register.jsp页面传递过来的用户数据来设置User Bean，
	   使用<jsp:setProperty>的多种方式来获取表单中的数据；
	3、使用<jsp:getProperty>动作获取Bean中属性的值，并显示在doRegister.jsp页面上。
 --%>
 <jsp:useBean id="user" class="cn.jspcourse.exp.ch5.User"/>
 <jsp:setProperty name="user" property="*" />
 <jsp:getProperty name="user" property="userName"/>
  <jsp:getProperty name="user" property="userPwd"/>
   <jsp:getProperty name="user" property="sex"/>
    <jsp:getProperty name="user" property="email"/>
     <jsp:getProperty name="user" property="userPhoto"/>
      <jsp:getProperty name="user" property="userDes"/>
 
 
 
 
 
 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>doRegister.jsp</title>
    
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
 
  </body>
</html>
