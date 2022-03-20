<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <title>Request对象演示</title>
</head>
<body>
<h2 align="center"> Request 请求信息</h2>
<hr>
JSP 请求方法：<%= request.getMethod() %> <br>
请求 URI：<%= request.getRequestURI() %> <br>
请求协议：<%= request.getProtocol() %> <br>
Servlet 路径<%= request.getServletPath() %> <br>
远程用户：<%= request.getRemoteUser() %> <br>
远程地址：<%= request.getRemoteAddr() %> <br>
远程主机：<%= request.getRemoteHost() %> <br>
路径信息：<%= request.getPathInfo() %> <br>
内容长度：<%= request.getContentLength() %> <br>
内容类型：<%= request.getContentType() %> <br>
服务器名：<%= request.getServerName() %> <br>
服务器端口：<%= request.getServerPort() %> <br>
<hr>
您使用的浏览器是： <%= request.getHeader("User-Agent") %>
<hr>
<%
out.println("Protocol: " + request.getProtocol() + "<br>");
out.println("Scheme: " + request.getScheme() + "<br>");
out.println("Server Name: " + request.getServerName() + "<br>" );
out.println("Server Port: " + request.getServerPort() + "<br>");
out.println("Protocol: " + request.getProtocol() + "<br>");
out.println("Server Info: " + getServletConfig().getServletContext().getServerInfo() + "<br>");
out.println("Remote Addr: " + request.getRemoteAddr() + "<br>");
out.println("Remote Host: " + request.getRemoteHost() + "<br>");
out.println("Character Encoding: " + request.getCharacterEncoding() + "<br>");
out.println("Content Length: " + request.getContentLength() + "<br>");
out.println("Content Type: "+ request.getContentType() + "<br>");
out.println("Auth Type: " + request.getAuthType() + "<br>");
out.println("HTTP Method: " + request.getMethod() + "<br>");
out.println("Path Info: " + request.getPathInfo() + "<br>");
out.println("Path Trans: " + request.getPathTranslated() + "<br>");
out.println("Query String: " + request.getQueryString() + "<br>");
out.println("Remote User: " + request.getRemoteUser() + "<br>");
out.println("Session Id: " + request.getRequestedSessionId() + "<br>");
out.println("Request URI: " + request.getRequestURI() + "<br>");
out.println("Servlet Path: " + request.getServletPath() + "<br>");
out.println("Accept: " + request.getHeader("Accept") + "<br>");
out.println("Host: " + request.getHeader("Host") + "<br>"); 
out.println("Referer : " + request.getHeader("Referer") + "<br>"); 
out.println("Accept-Language : " + request.getHeader("Accept-Language") + "<br>"); 
out.println("Accept-Encoding : " + request.getHeader("Accept-Encoding") + "<br>"); 
out.println("User-Agent : " + request.getHeader("User-Agent") + "<br>"); 
out.println("Connection : " + request.getHeader("Connection") + "<br>"); 
out.println("Cookie : " + request.getHeader("Cookie") + "<br>"); 



%>
</body></html>
