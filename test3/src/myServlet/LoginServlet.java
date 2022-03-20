package myServlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {





	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


//	public void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//      response.setCharacterEncoding("GBK");
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
//		out.println("<HTML>");
//		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
//		out.println("  <BODY>");
//		out.print("    This is ");
//		out.print(this.getClass());
//		out.println(", using the GET method");
//		out.println("<h1>他好像有那个大病</h1>");
//		out.println("  </BODY>");
//		out.println("</HTML>");
//		out.flush();
//		out.close();
////        response.setCharacterEncoding("GBK");
////        response.getWriter().write("菜鸟教程：http://www.runoob.com");
//	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
	      response.setCharacterEncoding("GBK");
		PrintWriter out = response.getWriter();

		String memberServletURL ="MemberServlet";
		String error1URL ="../error1.html";
		String error2URL = "http://magicbook:8080/test3/error2.html";
		String username=request.getParameter("username");
		String password=request.getParameter("password");

		@SuppressWarnings("unused")
		USER user=new USER(username,password);

		if(username.equals("jack")&&password.equals("1234")){
			HttpSession session=request.getSession();
			session.setAttribute("user1", username);
			session.setAttribute("pass1", password);
			response.setHeader("Refresh", "0;URL="+memberServletURL);
		
		}
		else if(username.equals("")||password.equals("")||username==""||password==""){
			response.setHeader("Refresh", "0;URL="+error1URL);
		}
		else{
			response.setHeader("Refresh", "0;URL="+error2URL);
		}
		out.close();
	}


	public void init() throws ServletException {
		// Put your code here
	}

}
class USER{
	private String username;
	private String password;
	public USER(String username, String password) {
		super();
		this.setUsername(username);
		this.setPassword(password);
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	
}