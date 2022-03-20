package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDao;

import enity.User;

public class UserServlet extends HttpServlet {

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
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		User user = new User(name, password);
		
		UserDao search = new UserDao();

		int flag = search.searchUser(user);
		if (flag == 1) {
			HttpSession session=request.getSession();	//�ص㣡����
			session.setAttribute("user", user);
		
			response.sendRedirect("../welcome.jsp");
		} else if (flag == 0) {
			out.println("�������");
			out.println("�볢�����µ�¼��<br><br>3����Զ���ת����¼ҳ��...");
			response.setHeader("REFRESH", "3,url="+"../login.jsp");
		} else {
			out.println("�������Ǳ���վ���û�������ע�ᣡ<br><br>3����Զ���ת��ע��ҳ��...");
			response.setHeader("REFRESH", "3,url="+"../register.jsp");
		}

		out.flush();
		out.close();
	}

}
