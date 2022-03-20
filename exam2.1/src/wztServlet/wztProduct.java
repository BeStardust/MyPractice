package wztServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wztDB.WztDBcon;
import wztDao.WztProductDao;

public class wztProduct extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		WztProductDao wztFind =new WztProductDao();
		ResultSet rs = wztFind.wztFindAllProduct();
		try {
			while (rs.next()) {
			out.println("wzt产品名："+rs.getString(1)+"      wzt型号："+rs.getString(2)+"      wzt厂商："+rs.getString(3)+"<br><br>");	
				
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
//		out.println("<HTML>");
//		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
//		out.println("  <BODY>");
//		out.print("    This is ");
//		out.print(this.getClass());
//		out.println(", using the GET method");
//		out.println("  </BODY>");
//		out.println("</HTML>");
		out.flush();
		out.close();
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String WZTname=request.getParameter("WZTname");
		String WZTxinghao=request.getParameter("WZTxinghao");
		String WZTchangshang=request.getParameter("WZTchangshang");

		WztProductDao wztAdd =new WztProductDao();
		wztAdd.wztAddProduct(WZTname, WZTxinghao, WZTchangshang);

		PrintWriter out = response.getWriter();
		out.println("添加成功！");
//		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
//		out.println("<HTML>");
//		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
//		out.println("  <BODY>");
//		out.print("    This is ");
//		out.print(this.getClass());
//		out.println(", using the POST method");
//		out.println("  </BODY>");
//		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
