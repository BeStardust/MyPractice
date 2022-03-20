<%-- 用户注册页面 --%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
	<head>
		<title>用户注册</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" href="css/style.css" type="text/css"
			media="screen" />
		<meta name="author" content="John Ulotti, UQ Web Design" />

	</head>
<script type="text/javascript">
    function CheckData()
     {
         if(document.addAdminForm.userName.value == "")
        {
            alert("用户名不能为空！");
            document.addAdminForm.userName.focus();
            return false;
         }
        if(document.addAdminForm.userPwd.value == "")
         {
             alert("密码不能为空！");
             document.addAdminForm.userPwd.focus();
             return false;
         }
         if(document.addAdminForm.pwdConfirm.value == "")
         {
             alert("密码确认不能为空！");
             document.addAdminForm.pwdConfirm.focus();
             return false;
         }
         if(document.addAdminForm.userPwd.value != document.addAdminForm.pwdConfirm.value)
         {
             alert("两次密码输入不一致");
             document.addAdminForm.pwdConfirm.focus();
             return false;
         }
         
         //检查邮箱地址
         if(document.addAdminForm.email.value != "")
         {
             var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
             if(!reg.test(document.addAdminForm.email.value))
             {
                 alert("Email格式不正确！");
                 document.addAdminForm.email.focuse();
                 return false;
             }
             return true;
         }
        
     }
</script>


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
						用户注册模块
					</h1>
					<p>
						在表单中填写相应信息进行用户注册，带*的项为必填项。
					</p>
					<div class="text">

						<%-- 将用户填写的注册数据提交给#.jsp处理 --%>
						<form method="post" action="doRegister.jsp" class="form"
							name="addAdminForm">
							<fieldset>
								<legend>
									用户名:
								</legend>


								<input tyep="text" name="userName" size="18" />
								* 用户名可使用英文、下划线、数字，总字符数在4 - 16之间。
							</fieldset>
							<br />
							<br />
							<br />
							<fieldset>
								<legend>
									登录密码:
								</legend>
								<input type="password" name="userPwd" size="19" />
								*
							</fieldset>
							<br />
							<br />
							<br />
							<fieldset>
								<legend>
									密码确认:
								</legend>
								<input type="password" name="pwdConfirm" size="19" />
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
								<input type="radio" value="1" id="sex" name="sex" />
								<label for="sex">
									女
								</label>
								<input type="radio" value="2" id="sex" name="sex" />
								<label for="sex">
									保密
								</label>
								<input type="radio" value="3" id="sex" name="sex"
									checked="checked" />
							</fieldset>
							<br />
							<br />
							<br />

							<fieldset>
								<legend>
									电子邮箱:
								</legend>
								<input type="text" name="email" size="30" />
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

								<textarea cols="65" rows="5" id="contactus" name="contactus">
		
								</textarea>
							</fieldset>
							<br />
							<br />
							<br />
							<input type="submit" value="注册" class="button" onClick="return CheckData()" />
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
