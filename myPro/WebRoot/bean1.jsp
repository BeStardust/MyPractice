<%@ page contentType="text/html;charset=GB2312"%>
<%@ page import="myPackge.*"%>
<HTML>
	<BODY bgcolor=cyan>
		<font size=1> <jsp:useBean id="girl" class="myPackge.Circle"
				scope="session">
			</jsp:useBean>
			<p>
				Բ�İ뾶�ǣ�
			</p> <%=girl.getRadius()%> <a href="bean2.jsp"><BR>bean2.jsp </a>
	</BODY>
</HTML>
