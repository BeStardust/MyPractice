
<%--用户登录页面，在本页面用户填写用户名与密码，并提交给login.jsp处理 --%>

<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
	<head>
		<title>用户登录</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" href="css/style.css" type="text/css"
			media="screen" />
		<meta name="author" content="John Ulotti, UQ Web Design" />

	</head>

	<body>
		<div class="container">


			<%--在此处使用include指令或者jsp：include动作包含header.jsp文件 --%>
			<jsp:include page="include/header.jsp" />
 
			<%--包含header.jsp文件结束 --%>
			<div class="menuleft">
				<%--左边Menu部分，在本页面保持空白 --%>
			</div>
			<div class="content">
				<div class="menuright">
					<%-- 右边Menu的内容部分，在本页面保持空白 --%>
				</div>
				<%-- 中间内容部分 --%>
				<div class="indexcontent">
					<h1>
						用户登录模块
					</h1>
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />
					<br />

					<div class="text">

						<%-- 修改表单，将表单的数据提交给login.jsp处理 --%>
						<form method="post" action="login.jsp" class="form"
							name="register">
							<fieldset>
								<legend>
									用户名:
								</legend>


								<input tyep="text" name="userName" size="18" />
								*
							</fieldset>
							<br />
							<br />
							<br />
							<fieldset>
								<legend>
									登录密码:
								</legend>
								<input type="password" name="pwd" size="19" />
								忘记密码？ *
							</fieldset>
							<br />
							<br />
							<br />
							<br />
							<br />
							<br />
							<br />
							<br />
							<br />
							<input type="submit" value="登录" class="button" />
							&nbsp;
							<input type="reset" value="重置" class="button" />
							&nbsp;
						</form>
						<br />
					</div>

					<%@include file="include/footer.jsp"%>
				</div>

			</div>
		</div>

	</body>
</html>
