package wztServlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import DAO.DoUser;
import User.*;

public class testLogin extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");

		// Cookie cookieName = new Cookie("name", name);
		// cookieName.setMaxAge(3);
		// cookieName.setPath("/");
		// response.addCookie(cookieName);
		out.print("hello<br>");
		out.print(name);

		User user = new User();
		user.setName(name);
		DoUser doUser = new DoUser();
		boolean flag = doUser.searchUser(user);
		if (flag == true) {
			out.println("是本站用户");
		} else {
			out.println("不是本站用户");
		}
		out.flush();
		out.close();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		String name =new String(request.getParameter("name").getBytes("ISO8859-1"),"utf-8");
		out.print(name);
		User user = new User();
		user.setName(name);
		DoUser doUser = new DoUser();
		boolean flag=doUser.addUser(user);
		out.flush();
		out.close();
	}
}