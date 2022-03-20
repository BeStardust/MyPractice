<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" errorPage="/errors/error.jsp" import="java.sql.*"%>

<%
	String user = (String) session.getAttribute("user");
	if (user == null) {
		throw new Exception("你还未登陆，无权访问此页面");
	}
	if (!user.equals("admin")) {
		throw new Exception("你不是管理员，无权访问此页面");

	}
%>
<%--	--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
	<head>
		<title>Web应用开发技术-JSP 课程示例程序</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" href="../css/style.css" type="text/css"
			media="screen" />
		<meta name="author" content="John Ulotti, UQ Web Design" />
	</head>
	<body>
		<div class="container">


			<jsp:include page="/include/header.jsp"></jsp:include>

			<div class="menuleft">

				<div class="menuheader">
					欢迎您：
				</div>



				<br />

				<div class="menuheader">
					后台管理
				</div>

				<div class="menucontent">

					<ul id="category">
						<li id="category-active">
							<a href="#">Selected category</a>
						</li>
						<!-- Active -->
						<li>
							<a href="userManager.jsp">用户管理</a>
						</li>
						<li>
							<a href="#">Category</a>
						</li>
						<li>
							<a href="#">Category</a>
						</li>
						<li>
							<a href="#">Category</a>
						</li>
					</ul>

				</div>


				<br />





			</div>
			<%--包含header.jsp文件结束 --%>

			<div class="content">
				<div class="menuright">
					<br />

					<div class="menuheader">
						在线用户列表：
					</div>

					<div class="menucontent">

						<div class="text">
							<p>
								<a href="#" title="Link">News Link</a>
							</p>
							<p>
								<a href="#" title="Link">News Link</a>
							</p>
							<p>
								<a href="#" title="Link">News Link</a>
							</p>
							<p>
								<a href="#" title="Link">News Link</a>
							</p>
							<p>
								<a href="#" title="Link">News Link</a>
							</p>
							<p>
								<a href="#" title="Link">News Link</a>
							</p>
						</div>

					</div>

				</div>
				<div class="indexcontent">
					<h1>
						注册用户列表
					</h1>

					<p>
					</p>
					<table width="100%" border="1" height="73" class="table">
						<tbody>
							<tr>
								<td width="40%">
									&nbsp;用户
								</td>
								<td width="40%">
									&nbsp;电子邮件
								</td>
								<td>
									&nbsp;修改
								</td>
								<td>
									删除
									<br />
								</td>
							</tr>
							
							<tr>
								<td></td>
								<td></td>
								<td> 
									<a href="modifyUserInfo.jsp?action=modifyUserInfo&id=" title="修改用户信息">&nbsp;修改</a> 
								</td>
								<td> 
									<a href="deleteUser.jsp?action=deleteUser&id=" title="删除用户">&nbsp;删除</a> 
								</td>
							</tr>
							
						</tbody>
					</table>
					<p>
					</p>

					<div class="footer">
						<hr class="dash" />
						<p>
							&copy; Copyright
							<a href="http://www.uqwebdesign.com" title="UQ Web Design">UQ
								Web Design</a> 2006
						</p>
					</div>
				</div>

			</div>
		</div>

	</body>
</html>