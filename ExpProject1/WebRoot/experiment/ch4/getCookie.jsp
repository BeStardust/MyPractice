<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title></title>
	</head>

	<body>
		<%
			//从request中获得Cookies集
			Cookie[] cookies = request.getCookies();
			//初始化Cookie对象为空
			Cookie cookie_response = null;
			String timeString = new java.util.Date().toString();
			if (cookies != null) {
				cookie_response = cookies[0];
			}
			out.println("本次访问时间：" + timeString + "<br>");

			if (cookie_response != null) {
				//输出上一次访问的时间。并设置cookie_response对象为最新时间。
				out.println("上一次访问时间：" + cookie_response.getValue()+"<br>");
					
				cookie_response.setValue(timeString);
				response.addCookie(cookie_response);
			}
			//如果Cookies集为空，创建cookie，并加入到response中
			if (cookies == null) {
				cookie_response = new Cookie("AccessTime", "");
				cookie_response.setValue(timeString);
				response.addCookie(cookie_response);
			}
		%>
	</body>
</html>