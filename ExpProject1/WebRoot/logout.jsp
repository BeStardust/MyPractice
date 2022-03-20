<%-- 登录用户注销处理页面 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%-- 在本页面中实现让session失效，并跳转回index.jsp页面--%>
<%
	session.invalidate();
	response.sendRedirect("index.jsp");



%>