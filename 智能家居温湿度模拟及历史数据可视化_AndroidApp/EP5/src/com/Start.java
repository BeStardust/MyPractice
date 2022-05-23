package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Start extends HttpServlet {

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

		//
		// response.setContentType("text/html");
		// PrintWriter out = response.getWriter();
		// out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		// out.println("<HTML>");
		// out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		// out.println("  <BODY>");
		// out.print("    This is ");
		// out.print(this.getClass());
		// out.println(", using the GET method");
		// out.println("  </BODY>");
		// out.println("</HTML>");
		// out.flush();
		// out.close();
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

		// 设置跨域访问 　　
//		response.setHeader("Access-Control-Allow-Origin", "*");
//		response.setHeader("Access-Control-Allow-Methods", "*");
//		response.setHeader("Access-Control-Max-Age", "4200");
//		response.setHeader("Access-Control-Allow-Headers", "*");
//		response.setHeader("Access-Control-Allow-Credentials", "true");

		// 读取请求内容
		BufferedReader br = new BufferedReader(new InputStreamReader(
				request.getInputStream(), "utf-8"));
		String line = null;
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		// 将json字符串转换为json对象
		JSONObject dateJSON = JSONObject.fromObject(sb.toString());
		//System.out.println(dateJSON);

		String pathname = "/Data/" + dateJSON.getString("device") + "/"
				+ dateJSON.getString("device_id") + "/"
				+ dateJSON.getString("year") + "/"
				+ dateJSON.getString("month") + "/" + dateJSON.getString("day")
				+ "_data.json";
		// System.out.println(pathname);
		
		String data = "";		
		InputStream is = getServletContext().getResourceAsStream(pathname);

		if (is != null) {
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader reader = new BufferedReader(isr);
			
			String text;
			while ((text = reader.readLine()) != null) {
				data = data + text;
			}
		}
		JSONArray dataJsonArray = JSONArray.fromObject(data);
		//System.out.println(dataJsonArray);
		response.setContentType("application/json");
		response.getWriter().write(String.valueOf(dataJsonArray));
		
		// String pathname =
		// "D:\\Workspaces\\MyEclipseWorkspaces\\.metadata\\.me_tcat\\webapps\\EP5\\Data\\temp_device\\device1\\2022\\01\\01_data.json";
		//
		// BufferedReader reader = new BufferedReader(new FileReader(pathname));
		// String data;
		// while ((data = reader.readLine()) != null) {
		// System.out.println(data);
		// }
		// System.out.println(data);

		// JSONObject testJsonObject1 = new JSONObject();
		// testJsonObject1.put("test", "value");
		// JSONObject testJsonObject2 = new JSONObject();
		// testJsonObject2.put("test", "value");
		// response.setCharacterEncoding("utf-8");
		//JSONArray jsonArray = new JSONArray();
		// jsonArray.add(testJsonObject1);
		// jsonArray.add(testJsonObject2);
//		response.setContentType("application/json");
//		response.getWriter().write(String.valueOf(jsonArray));

		// PrintWriter out = response.getWriter();
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
