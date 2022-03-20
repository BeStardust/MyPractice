<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" errorPage="/errors/error.jsp" import="java.sql.*"%>
<% String user = (String)session.getAttribute("user");
	if(user==null){
		throw new Exception("你还未登陆，无权访问此页面");
	}
	if(!user.equals("admin")){
		throw new Exception("你不是管理员，无权访问此页面");
		
	}

%>
<%

	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
	<head>
		<title>Web应用开发技术-JSP 课程示例程序</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" href="../css/style.css" type="text/css" media="screen" />
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
						用户信息修改模块
					</h1>
					<p>
						在表单中修改用户注册信息，带*的项为必填项。
					</p>
					<div class="text">

						<%-- 将用户填写的注册数据提交给#.jsp处理 --%>
						<form method="post" action="doModifyUserInfo.jsp" class="form"
							name="register">
							<input type="hidden" name="userId" value=""/>
							
							<fieldset>
								<legend>
									用户名:
								</legend>


								<input tyep="text" name="userName" size="18" value="" />
								* 用户名可使用英文、下划线、数字，总字符数在4 - 16之间。
							</fieldset>
							<br />
							<br />
							<br />
							<fieldset>
								<legend>
									登录密码:
								</legend>
								<input type="password" name="pwd" size="19" value="" />
								*
							</fieldset>
							<br />
							<br />
							<br />
							<fieldset>
								<legend>
									密码确认:
								</legend>
								<input type="password" name="pwdConfirm" size="19" value="" />
								*
							</fieldset>
							<br />
							<br />
							<br />
							<fieldset>
								<legend>
									性别:
								</legend>
								
								<label for="sex">
									男
								</label>
								
								<input type="radio" value="男" id="sex" name="sex" checked="checked" />
								<label for="sex">
									女
								</label>
								<input type="radio" value="女" id="sex" name="sex" />
								<label for="sex">
									保密
								</label>
								<input type="radio" value="保密" id="sex" name="sex"
									 />
								
							</fieldset>
							<br />
							<br />
							<br />

							<fieldset>
								<legend>
									电子邮箱:
								</legend>
								<input type="text" name="email" size="30" value=""/>
								*
							</fieldset>
							<br />
							<br />
							<br />

							<fieldset>
								<legend>
									照片:
								</legend>
								<label for="myimage">
									个性照片上传
								</label>
								<input type="file" id="myimage" name="myimage" size="35"
									maxlength="255" />
							</fieldset>
							<br />
							<br />
							<br />

							<fieldset>
								<legend>
									个性签名
								</legend>

								<textarea cols="65" rows="5" id="userDescription" name="userDes" >
	
								</textarea>
							</fieldset>
					
							<br />
							<br />
							<br />
							<input type="submit" value="修改" class="button" />
							&nbsp;
							<input type="reset" value="重置" class="button" />
							&nbsp;
						</form>
						<br />
					</div>

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
<span style="display: none;"><a href="http://www.mobanwang.com"
	title="��ҳģ������">��ҳģ��</a> </span>