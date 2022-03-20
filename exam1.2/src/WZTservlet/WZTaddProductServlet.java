package WZTservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import WZTproduct.wztProduct;

public class WZTaddProductServlet extends HttpServlet {





	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		String WZTname=request.getParameter("WZTname");
		String WZTxinghao=request.getParameter("WZTxinghao");
		String WZTchangshang=request.getParameter("WZTchangshang");
		wztProduct wztP = new wztProduct(WZTname, WZTxinghao, WZTchangshang);
		HttpSession session = request.getSession();
		session.setAttribute("wztProduct",wztP);
		
//		response.sendRedirect("../WZTshowProduct.jsp");
		response.setHeader("REFRESH", "0,URL="+"../WZTshowProduct.jsp");
		
//		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
//		out.println("<HTML>");
//		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
//		out.println("  <BODY>");
//		out.print("    This is ");
//		out.print(this.getClass());
//		out.println(", using the POST method");
//		out.println("  </BODY>");
//		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
