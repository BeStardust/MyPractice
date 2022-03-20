package myServlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {


	public LoginServlet() {
		super();
	}


	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
	      response.setCharacterEncoding("GBK");
	      request.setCharacterEncoding("UTF-8");
	      Connection con=null;
	      PreparedStatement pst=null;
	      ResultSet rs=null;
	      
	      PrintWriter out = response.getWriter();

//		String memberServletURL ="MemberServlet";
//		String error1URL ="../error1.html";
//		String error2URL = "http://magicbook:8080/test4/error2.html";
		String username=request.getParameter("username");
		String password=request.getParameter("password");
//		String remember=request.getParameter("remember");
		if(username.equals("")||username==null||password.equals("")||username==null){
			out.println("用户名或密码不能为空");
			response.setHeader("Refresh", "2;URL="+"../");
		}else {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/jspexe", "root", "wuzhuanti");
				System.out.println("linked");
				String sql="select * from usertable";
				pst = con.prepareStatement(sql);
		
				rs = pst.executeQuery();
				boolean exist=false;
				while(rs.next()){
					if(username.equals(rs.getString("username"))||username==rs.getString("username")){
			
						if(password.equals(rs.getString(3))){
							out.println("登录成功！");
							response.setHeader("Refresh", "2;URL="+"../member.jsp");
						}
						else{
							out.println("密码错误！");
							response.setHeader("Refresh", "2;URL="+"../error.jsp");
						}
		
						exist=true;
						break;
					}

				}
				if(exist==false){
					out.println("用户不存在！");
					response.setHeader("Refresh", "2;URL="+"../register.jsp");
				}

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				if (rs!=null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (pst!=null) {
					try {
						pst.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (con!=null) {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
					
				
			}
		}


		
		
//		if(username.equals("jack")&&password.equals("1234")){
//			HttpSession session=request.getSession();
//			session.setAttribute("user1", username);
//			session.setAttribute("pass1", password);
//			if(remember!=null&&remember.equals("yes")){
//				
//				Cookie cookie1=new Cookie("username", username);
//				cookie1.setMaxAge(10);
//				cookie1.setPath("/");
//				
//				Cookie cookie2=new Cookie("password", password);
//				cookie2.setMaxAge(10);
//				cookie2.setPath("/");
//				
//				response.addCookie(cookie1);
//				response.addCookie(cookie2);
//				
//			}
//			
//			response.sendRedirect(path+"/member.jsp");
//
//				
////			response.setHeader("Refresh", "0;URL="+memberServletURL);
//		
//		}
//
//		else{
//			response.setHeader("Refresh", "0;URL="+"../error.jsp");
//		}
		out.close();

	}

	public void init() throws ServletException {
		// Put your code here
	}

}
