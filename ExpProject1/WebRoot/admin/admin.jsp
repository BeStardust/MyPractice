<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" errorPage="/errors/error.jsp"%>
<%-- 
	获取session对象中，user属性的值，
	1、如果user的值为admin，则可以访问本页；
	2、如果user为null为空，抛出“你还未登陆”的异常，并交予errors/error.jsp；
	3、如果user不为空，其值也不等于admin，则抛出“你不是管理员，无法访问本页”的异常，
	同样交予errors/error.jsp
--%>
<%-- 编写JSP代码区 --%>
<% String user = (String)session.getAttribute("user");
	if(user==null){
		throw new Exception("你还未登陆，无权访问此页面");
	}
	if(!user.equals("admin")){
		throw new Exception("你不是管理员，无权访问此页面");
		
	}

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
						Web应用开发技术课程示例项目 系统管理模块
					</h1>
					<p>
						此HTML模板主要用于课堂练习使用，模板版权归设计者所有。
					</p>
					<h2>
						演示项目说明
					</h2>
					<p>
						Lorem ipsum dolor sit amet, varius et urna nulla consequat, elit
						et at donec sapien at turpis, non augue quam ligula leo quis, odio
						dignissim. Adipiscing convallis ornare non, quam tempus risus
						mattis aliquam eu in, ridiculus lobortis, quis ipsum arcu rutrum
						sit orci ac, non ipsum lacus sollicitudin quam nostra. Pharetra
						eget ridiculus ac varius, sit habitant integer suspendisse sed,
						augue ullamcorper libero, neque lacus semper eget, convallis metus
						varius arcu ipsam. Natoque dolor faucibus, senectus ac et sit
						vitae, viverra montes semper aliquet, dignissim mi mauris orci ut.
						Morbi urna nunc platea vitae nullam in, justo magna nullam
						curabitur cras sed, orci elit adipiscing nisl lobortis phasellus,
						massa nulla, aliquam mauris platea fusce.
					</p>

					<p>
						Ultricies eu lectus nisl etiam, dui sed, ut dui vulputate etiam
						ultricies, eros imperdiet id ipsum luctus porttitor nulla, augue
						odio neque diam ac praesent accumsan. Velit nec tempus, ultricies
						eros. Eu quis ante, nec lorem sociosqu integer dis eleifend, nulla
						odio vitae non ac mattis turpis. Euismod mauris vel magnis,
						aliquam mattis vivamus tempus est erat tincidunt, eu risus. Congue
						sapien. Etiam sed fermentum massa sapien, eget tristique ac dolor
						sed ipsum, velit arcu penatibus risus, ultricies diam in. Eget
						quam lectus nulla in lectus potenti, velit libero placerat
						vivamus, proin in, penatibus maecenas purus, ultrices integer et
						nec at purus class. Sem lacinia turpis. Sed fusce, suspendisse
						condimentum ut felis. Sit est cras sed.
					</p>


					<h2>
						Subheading
					</h2>
					<p>
						Torquent pede phasellus. Ut aliquam vivamus ipsum sodales. Aliquam
						orci fermentum ut, orci dolor placerat lorem mauris hac nonummy.
						Tellus sit semper eget fermentum, nec non wisi suspendisse risus
						risus, semper ipsum, suspendisse sed et suscipit vivamus lectus
						pulvinar, vulputate curabitur purus pretium eu libero est. Erat in
						placerat metus arcu nec, cras orci felis, sit magnis nonummy
						luctus velit accumsan, ut fusce sed, a turpis mattis molestie
						libero arcu nulla. Sollicitudin magna quam nulla nulla suscipit
						sagittis, scelerisque tellus donec, consectetuer posuere ipsum
						vestibulum metus imperdiet at, diam elit, at pede leo dui. Orci
						pellentesque nonummy habitasse suspendisse. Lorem purus in vel,
						massa nunc wisi, cursus purus ac, repellendus mi nunc suspendisse
						nam amet.
					</p>

					<p>
						A curabitur quo donec, ut a ante, amet pulvinar nunc eleifend,
						hendrerit aliquam non. Gravida lectus ante potenti tortor donec,
						consequat sit vel sem quis voluptatem, pellentesque volutpat lorem
						eu at viverra. Mauris wisi pellentesque metus erat in blandit,
						egestas eget fusce lorem, at risus, quis quia tempus lorem aut.
						Tristique vel hac. Phasellus nulla magnis massa dolor placerat,
						proin id libero at pretium curabitur, ut blandit fermentum mauris,
						magna egestas nulla, sit ornare dui. Feugiat arcu vitae rutrum
						nisl sed, nascetur et mauris, cum pellentesque nisl, ultricies
						aliquam cras eu, adipiscing velit lorem. At vestibulum, sed
						suspendisse vestibulum, enim imperdiet ut ultricies eleifend. A
						inceptos vitae ut aliquam, lectus ligula neque dolores accumsan
						praesent mauris, orci arcu quisque purus ullamcorper urna etiam,
						ipsum nonummy viverra. Elit in tempor sociosqu ut orci orci, at
						ante et.
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
<span style="display: none;"><a href="http://www.mobanwang.com"
	title="��ҳģ������">��ҳģ��</a> </span>