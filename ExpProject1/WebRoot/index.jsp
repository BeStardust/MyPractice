<%-- 系统首页 --%>
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
		<meta name="author" content="John Ulotti, UQ Web Design" />
	</head>
	<body>
		<div class="container">

			<%--在此处使用include指令包含header.jsp文件 --%>
			<%--@ include file="include/header.jsp"--%>
			<jsp:include page="include/header.jsp" />

			<%--包含header.jsp文件结束 --%>
			<div class="menuleft">
				<%--在此处使用jsp：include动作包含leftMenu.jsp文件 --%>

				<jsp:include page="include/leftMenu.jsp" />



			</div>
			<div class="content">
				<div class="menuright">
					<!-- 在此处包含rightMenu.jsp -->
					<%--@ include file="include/rightMenu.jsp" --%>

					<jsp:include page="include/rightMenu.jsp" />
				</div>
				<div class="indexcontent">
					<h1>
						Web应用开发技术课程示例项目
					</h1>

					<h2>
						演示项目说明
					</h2>
					<p>
						本项目主要用于Web应用开发(JSP)课程的课堂演示与实验课练习。
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
					<!-- 包含footer.jsp -->
					<%--@ include file="include/footer.jsp" --%>
					<jsp:include page="include/footer.jsp" />
				</div>

			</div>
		</div>

	</body>
</html>