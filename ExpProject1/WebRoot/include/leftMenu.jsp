<!-- 左边菜单部分 -->
<%@ page language="java" contentType="text/html;charset=UTF-8" import="java.util.*"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String user = (String) session.getAttribute("user");
%>


<div class="menuheader">
	<%-- 添加JSP代码，实现功能如下：
	1、如果是登录的用户，显示欢迎您：[用户名]；
	2、反之，显示，欢迎您：游客								
--%>
	欢迎您：

</div>

<div class="menucontent">

	<a href="<%=path%>/register.jsp">注册</a> &nbsp;&nbsp;
	<a href="<%=path%>/logon.jsp">登录</a> &nbsp;&nbsp;
	<a href="<%=path%>/logout.jsp">退出</a>

</div>

<br />

<div class="menuheader">
	最新信息
</div>

<div class="menucontent">

	<ul id="category">
		<li id="category-active">
			<a href="#">Selected category</a>
		</li>
		<!-- Active -->
		<li>
			<a href="#">Category</a>
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

<div class="menuheader">
	Archive
</div>

<div class="menucontent">



	<ul id="archive">
		<li>
			<a href="#">January 2007</a>
		</li>
		<li>
			<a href="#">December 2006</a>
		</li>
		<li>
			<a href="#">November 2006</a>
		</li>
		<li>
			<a href="#">October 2006</a>
		</li>
		<li>
			<a href="#">September 2006</a>
		</li>
		<li id="archive-active">
			<a href="#">August 2006</a>
		</li>
		<!-- Active -->
		<li>
			<a href="#">July 2006</a>
		</li>
		<li>
			<a href="#">June 2006</a>
		</li>
		<li>
			<a href="#">May 2006</a>
		</li>
		<li>
			<a href="#">April 2006</a>
		</li>
		<li>
			<a href="#">March 2006</a>
		</li>
		<li>
			<a href="#">February 2006</a>
		</li>
		<li>
			<a href="#">January 2006</a>
		</li>
	</ul>

</div>

