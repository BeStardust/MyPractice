<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" import="java.net.URLDecoder"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<div class="header">
	<img src="<%=path %>/images/header.gif" alt="UQ Web Design" />
	<div class="menucontent">





	</div>
</div>

<div class="nav">
	<a href="<%=path %>/index.jsp" title="Link">首页</a>
	<a href="<%=path %>/articleIndex.jsp" title="Link">信息列表</a>
	<a href="#" title="Link">Link 3</a>
	<a href="#" title="Link">Link 4</a>
	<a href="<%=path %>/admin/admin.jsp" title="Link">管理平台</a>
</div>



