import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@SuppressWarnings("serial")
public class Login extends HttpServlet {


	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
      response.setCharacterEncoding("GBK");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("<h1>他好像有那个大病</h1>");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
//        response.setCharacterEncoding("GBK");
//        response.getWriter().write("菜鸟教程：http://www.runoob.com");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
	      response.setCharacterEncoding("GBK");
		PrintWriter out = response.getWriter();
//		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
//		out.println("<HTML>");
//		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
//		out.println("  <BODY>");
//		out.print("    This is ");
//		out.print(this.getClass());
//		out.println(", using the POST method");
//		String username=request.getParameter("username");
////		String password=reque
//		out.println("  </BODY>");
//		out.println("</HTML>");
//		out.flush();
//		out.close();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		out.println("用户名:"+username);
		out.println("<br>");
		out.println("密码:"+password);
	}


	public void init() throws ServletException {
		// Put your code here
	}

}
