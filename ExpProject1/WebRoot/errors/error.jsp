<%-- 异常处理页面，主要显示错误信息 --%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
	<head>
		<title>Web应用开发技术-JSP 课程示例程序</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" href="<%=path%>/css/style.css" type="text/css"
			media="screen" />
		<meta name="author" content="John Ulotti, UQ Web Design" />

	</head>

	<body>
		<div class="container">


			<%--在此处使用include指令或者jsp：include动作包含header.jsp文件 --%>
			<jsp:include page="/include/header.jsp" />
			<%--包含header.jsp文件结束 --%>
			<div class="menuleft">
				<%--左边Menu部分，在本页面保持空白 --%>
			</div>
			<div class="content">
				<div class="menuright">
					<%-- 右边Menu的内容部分，在本页面保持空白 --%>
				</div>
				<div class="indexcontent">


					<div class="text">
						<img border="0" align="center" src="<%=path%>/images/errors.gif" />
						<br />
						<h5><%=exception.getMessage()%></h5>
						<br />
						<br />
						<a href="javascript:history.back(-1)">返回上一页&nbsp;</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

						<a href="<%=path%>/index.jsp">返回首页</a>
					</div>

				</div>
			</div>
	</body>
</html>
