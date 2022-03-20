package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@SuppressWarnings("serial")
public class CatalogServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();

	    int itemCount = 0;
	    HashMap cart = (HashMap) session.getAttribute("cart");
	    if (cart != null) {
	      itemCount = cart.size();

	    } 
	    res.setContentType("text/html;charset=gb2312");
	    PrintWriter out = res.getWriter();

	    out.println("<HTML><HEAD><TITLE>简单购物车 "
	                + "Example</TITLE></HEAD>");
	    out.println("<BODY><TABLE border=\"0\" width=\"100%\"><tr>");
	    out.println("<td align=\"left\" valign=\"bottom\">");
	    out.println("<H1>欢迎来到开心水果店购物</H1></td></tr></TABLE><HR>");
	    
	    out.print("<FORM ACTION=\"");
	    out.println(res.encodeURL("cart"));
	    out.println("\" METHOD=\"POST\">");
	    out.println("<TABLE CELLSPACING=\"5\" CELLPADDING=\"5\"><TR>");
	    out.println("<TD ALIGN=\"center\"><B>种类</B></TD>");
	    out.println("<TD ALIGN=\"center\"><B>单价</B></TD>");
	    out.println("<TD ALIGN=\"center\"><B>数量</B></TD></TR><TR>");
	    out.println("<TD ALIGN=\"center\">"+"苹果"+"</TD>");
	    out.println("<TD ALIGN=\"center\">"+"5.5"+"</TD>");
	    out.println("<TD ALIGN=\"center\">");
	    out.println("<INPUT  NAME=\"apple_amount\"" 
	                + " ></TD></TR><TR>");
	    
	    out.println("<TD ALIGN=\"center\">"+"香蕉"+"</TD>");
	    out.println("<TD ALIGN=\"center\">"+"4.5"+"</TD>");
	    out.println("<TD ALIGN=\"center\">");
	    out.println("<INPUT  NAME=\"banana_amount\"" 
	                + "></TD></TR><TR>");
	    
	    out.println("<TD ALIGN=\"center\">"+"葡萄"+"</TD>");
	    out.println("<TD ALIGN=\"center\">"+"3.6"+"</TD>");
	    out.println("<TD ALIGN=\"center\">");
	    out.println("<INPUT  NAME=\"grape_amount\"" 
	                + "></TD></TR>");
	    
	    out.println("</TABLE><HR>");
	    out.println("<INPUT TYPE=\"Submit\" NAME=\"btn_submit\" "
	                + "VALUE=\"放入购物车\">");
	    out.println("</FORM></BODY></HTML>");

	    out.close();

	}
}

