package myServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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




	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
	      response.setCharacterEncoding("GBK");
	      String path=request.getContextPath();
		PrintWriter out = response.getWriter();

		String memberServletURL ="MemberServlet";
		String error1URL ="../error1.html";
		String error2URL = "http://magicbook:8080/test4/error2.html";
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String remember=request.getParameter("remember");

		@SuppressWarnings("unused")
		USER user=new USER(username,password);

		if(username.equals("jack")&&password.equals("1234")){
			HttpSession session=request.getSession();
			session.setAttribute("user1", username);
			session.setAttribute("pass1", password);
			if(remember!=null&&remember.equals("yes")){
				
				Cookie cookie1=new Cookie("username", username);
				cookie1.setMaxAge(10);
				cookie1.setPath("/");//¹²Ïí
				
				Cookie cookie2=new Cookie("password", password);
				cookie2.setMaxAge(10);
				cookie2.setPath("/");
				
				response.addCookie(cookie1);
				response.addCookie(cookie2);
				
			}
			
			response.sendRedirect(path+"/servlet/MemberServlet");

				
//			response.setHeader("Refresh", "0;URL="+memberServletURL);
		
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