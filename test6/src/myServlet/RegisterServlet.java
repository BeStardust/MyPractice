package myServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet {


	public RegisterServlet() {
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

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String path = request.getContextPath();
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String passwordConfirm = request.getParameter("passwordConfirm");
		if (username.equals("")||password.equals("")||passwordConfirm.equals("")) {
			out.println("用户名或密码不能为空");
			response.setHeader("Refresh", "2;URL="+"../register.jsp");
		}else {
			if (password.equals(passwordConfirm)) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jspexe","root","wuzhuanti");
					System.out.println("Linked");
					String sql="insert into usertable values(DEFAULT,?,?)";
					PreparedStatement pst= conn.prepareStatement(sql);
					pst.setString(1, username);
					pst.setString(2, password);
					int flag=pst.executeUpdate();
					if (flag>1) {
						System.out.println("注册成功！");
						out.println("注册成功！\n3秒后自动返回登录界面");
						response.setHeader("Refresh", "3,URL="+"../register.jsp");
					}
					pst.close();
					conn.close();
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch (Exception e) {
					// TODO: handle exception
				}
				
				
			}else {		
				out.println("两次输入的密码不同，请重新输入");
				response.setHeader("Refresh", "2;URL="+"../register.jsp");
			}
		}


		out.close();

	}


	public void init() throws ServletException {
		// Put your code here
	}

}
