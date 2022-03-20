package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserDao;

import enity.User;

public class AddUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		// out.println("<HTML>");
		// out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		// out.println("  <BODY>");
		// out.print("    This is ");
		// out.print(this.getClass());
		// out.println(", using the GET method");
		// out.println("  </BODY>");
		// out.println("</HTML>");
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");

		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String passwordConfirm=request.getParameter("passwordConfirm");
		if (password.equals(passwordConfirm)==false) {
			out.println("两次密码输入不一致！，请重新注册！<br>");
			out.println("3秒后自动跳转至注册页面！");
			response.setHeader("REFRESH", "3,url="+"../register.jsp");
			return;
		}
		User user = new User(name, password);
		UserDao addUser = new UserDao();
		int flag = addUser.addUser(user);
		System.out.println("注册结果:" + flag);
		if (flag == 1) {
			out.println("您已注册成功，请尝试<a href=\"../login.jsp\">登录</a>");
		} else if (flag == 0) {
			out.println("注册失败！用户已存在，请尝试登录或更改用户名尝试重新注册！<br>");
			out.println("3秒后自动跳转至注册页面！");
			response.setHeader("REFRESH", "3,url="+"../register.jsp");
		} else {
			out.println("注册失败！<br>");
			out.println("3秒后自动跳转至注册页面！");
			response.setHeader("REFRESH", "3,url="+"../register.jsp");
			System.out.println("注册失败！");
		}
		out.flush();
		out.close();
	}

}
