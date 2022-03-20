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
			out.println("�����������벻һ�£���������ע�ᣡ<br>");
			out.println("3����Զ���ת��ע��ҳ�棡");
			response.setHeader("REFRESH", "3,url="+"../register.jsp");
			return;
		}
		User user = new User(name, password);
		UserDao addUser = new UserDao();
		int flag = addUser.addUser(user);
		System.out.println("ע����:" + flag);
		if (flag == 1) {
			out.println("����ע��ɹ����볢��<a href=\"../login.jsp\">��¼</a>");
		} else if (flag == 0) {
			out.println("ע��ʧ�ܣ��û��Ѵ��ڣ��볢�Ե�¼������û�����������ע�ᣡ<br>");
			out.println("3����Զ���ת��ע��ҳ�棡");
			response.setHeader("REFRESH", "3,url="+"../register.jsp");
		} else {
			out.println("ע��ʧ�ܣ�<br>");
			out.println("3����Զ���ת��ע��ҳ�棡");
			response.setHeader("REFRESH", "3,url="+"../register.jsp");
			System.out.println("ע��ʧ�ܣ�");
		}
		out.flush();
		out.close();
	}

}
