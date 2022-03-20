<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
当前时间是：
<%  String url="http://www.cuit.edu.cn";
	response.setHeader("refresh","10");
  out.println(new java.util.Date().toString());
  //response.setHeader("refresh","0;URL="+url);
  //response.sendRedirect("http://www.cuit.edu.cn");
 %>

</body>
</html>