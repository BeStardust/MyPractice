<%-- 文章索引首页 --%>

<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
	<head>
		<title>Web应用开发技术-JSP 课程示例程序</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" href="css/style.css" type="text/css"
			media="screen" />
		<link rel="stylesheet" media="screen,projection" type="text/css"
			href="css/main.css" />
		<link rel="stylesheet" media="print" type="text/css"
			href="css/print.css" />
		<link rel="stylesheet" media="aural" type="text/css"
			href="css/aural.css" />
		<meta name="author" content="John Ulotti, UQ Web Design" />
	</head>
	<body>
		<div class="container">

			<%--在此处使用include指令或者jsp：include动作包含header.jsp文件 --%>
			<jsp:include page="include/header.jsp" />

			<%--包含header.jsp文件结束 --%>
			<div class="menuleft">
			<%--在此处使用jsp：include动作包含leftMenu.jsp文件 --%>
			<jsp:include page="include/leftMenu.jsp"></jsp:include>
			
			
			</div>
			<div class="content">
				
				
					<h1>
						Web应用开发技术课程示例项目
					</h1>
					<!-- Article -->
					<div class="article">
						
						<p class="info noprint">
							<span class="date">2007-01-01 @ 00:01</span><span
								class="noscreen">,</span>
							<span class="cat"><a href="#">Category</a>
							</span><span class="noscreen">,</span>
							<span class="user"><a href="#">My name</a>
							</span><span class="noscreen">,</span>
							<span class="comments"><a href="#">Comments</a>
							</span>
						</p>

						<p>
							Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aliquam
							pellentesque enim blandit enim bibendum blandit. Integer eu leo
							ac est aliquet imperdiet. Quisque nec justo id augue posuere
							malesuada. Nullam ac metus. Cras non leo ut est placerat
							condimentum. Aliquam ut enim. Quisque non sapien in enim eleifend
							faucibus. Pellentesque sodales. Mauris auctor arcu sit amet
							felis. Donec eget enim ut lacus pharetra condimentum. Nulla in
							felis vel tortor imperdLorem ipsum dolor sit amet, consectetuer adipiscing elit. Aliquam
							pellentesque enim blandit enim bibendum blandit. Integer eu leo
							ac est aliquet imperdiet. Quisque nec justo id augue posuere
							malesuada. Nullam ac metus. Cras non leo ut est placerat
							condimentum. Aliquam ut enim. Quisque non sapien in enim eleifend
							faucibus. Pellentesque sodales. Mauris auctor arcu sit amet
							felis. Donec eget enim ut lacus pharetra condimentum. Nulla in
							felis vel tortor imperdLorem ipsum dolor sit amet, consectetuer adipiscing elit. Aliquam
							pellentesque enim blandit enim bibendum blandit. Integer eu leo
							ac est aliquet imperdiet. Quisque nec justo id augue posuere
							malesuada. Nullam ac metus. Cras non leo ut est placerat
							condimentum. Aliquam ut enim. Quisque non sapien in enim eleifend
							faucibus. Pellentesque sodales. Mauris auctor arcu sit amet
							felis. Donec eget enim ut lacus pharetra condimentum. Nulla in
							felis vel tortor imperdLorem ipsum dolor sit amet, consectetuer adipiscing elit. Aliquam
							pellentesque enim blandit enim bibendum blandit. Integer eu leo
							ac est aliquet imperdiet. Quisque nec justo id augue posuere
							malesuada. Nullam ac metus. Cras non leo ut est placerat
							condimentum. Aliquam ut enim. Quisque non sapien in enim eleifend
							faucibus. Pellentesque sodales. Mauris auctor arcu sit amet
							felis. Donec eget enim ut lacus pharetra condimentum. Nulla in
							felis vel tortor imperdLorem ipsum dolor sit amet, consectetuer adipiscing elit. Aliquam
							pellentesque enim blandit enim bibendum blandit. Integer eu leo
							ac est aliquet imperdiet. Quisque nec justo id augue posuere
							malesuada. Nullam ac metus. Cras non leo ut est placerat
							condimentum. Aliquam ut enim. Quisque non sapien in enim eleifend
							faucibus. Pellentesque sodales. Mauris auctor arcu sit amet
							felis. Donec eget enim ut lacus pharetra condimentum. Nulla in
							felis vel tortor imperdiet consectetuer. Sed id ante.
						</p>

						
					</div>
					<!-- /article -->

				

					<%@include file="include/footer.jsp"%>
				</div>

		</div>

	</body>
</html>
