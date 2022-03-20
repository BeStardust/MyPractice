<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>forward page</title>
</head>
<body>



<%
	request.setAttribute("参数","传递时间是"+new java.util.Date().toString());
	//response.sendRedirect("target.jsp");
	//response.setHeader("Refresh","1;URL=target.jsp");
	//request.getRequestDispatcher("target.jsp").forward(request,response);
	pageContext.forward("target.jsp");
%>
<%-- 
<jsp:forward page="target.jsp">
 <jsp:param name="forward" value="forward.jsp"/>
</jsp:forward>
--%>
</body>
</html>