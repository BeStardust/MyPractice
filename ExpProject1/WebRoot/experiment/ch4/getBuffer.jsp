<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" autoFlush="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
out.print("缓冲区大小："+response.getBufferSize()+"<br>");
out.print("缓冲区内容强制提交前<br>");
out.print("输出内容是否提交："+response.isCommitted()+"<br>");
response.flushBuffer();
out.print("缓冲区内容强制提交后<br>");
out.print("输出内容是否提交："+response.isCommitted()+"<br>");
%>
</body>
</html>