package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDao;

import enity.User;

import net.sf.json.JSONObject;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
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

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");

		// 读取请求内容
		BufferedReader br = new BufferedReader(new InputStreamReader(
				request.getInputStream(), "utf-8"));
		String line = null;
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		// 将json字符串转换为json对象
		JSONObject jsonData = JSONObject.fromObject(sb.toString());
		System.out.println(jsonData.getString("account"));
		System.out.println(jsonData.getString("passwd"));

		User user=new User();
		user.setAccount(jsonData.getString("account"));
		user.setPassword(jsonData.getString("passwd"));
		UserDao userDao=new UserDao();
		JSONObject respData = new JSONObject();// 即将返回前端数据
		respData.put("result", userDao.seekUser(user));
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		response.getWriter().write(String.valueOf(respData));

		/** * 接收json */
		// BufferedReader reader = request.getReader();
		// String json = reader.readLine();
		// System.out.println(json);
		// reader.close();

		// JSONObject jsonObject = new JSONObject();
		// jsonObject = jsonObject
		// .getJSONObject(request.getParameter("loginData"));
		//
		// Iterator iNames = jsonObject.keys();
		// while (iNames.hasNext()) {
		// System.out.println(iNames.hasNext());
		// }
		// PrintWriter out = response.getWriter();
		// String account=request.getParameter("account");
		// String passwd=request.getParameter("passwd");
		// if (!account.equals("")&&account!=null) {
		// if (!passwd.equals("")&&passwd!=null) {
		// System.out.println(account);
		// }
		// else {
		// System.out.println("no passwd");
		// }
		// }
		// else {
		// System.out.println("no account");
		// }

		// out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		// out.println("<HTML>");
		// out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		// out.println("  <BODY>");
		// out.print("    This is ");
		// out.print(this.getClass());
		// out.println(", using the POST method");
		// out.println("  </BODY>");
		// out.println("</HTML>");
		// out.flush();
		// out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
