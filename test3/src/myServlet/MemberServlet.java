package myServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class MemberServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public MemberServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String name=(String) session.getAttribute("user1");
		String password=(String) session.getAttribute("pass1");
		
		if(name==null||password==null){
			response.setHeader("Refresh", "0;URL="+"../Login.html");
		}
		
		else{
			response.setContentType("text/html"); response.setCharacterEncoding("GBK");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
			out.println("  <BODY>");
			out.print("    This is ");
			out.print(this.getClass());
			out.println(", using the GET method");
			out.println("<br>");
			out.println("ÓÃ»§Ãû:"+name);
			out.println("<br>");
			out.println("password:"+password);
			out.println("<br>");
			out.println("HELLO!");
			out.println("  </BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
		}

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
