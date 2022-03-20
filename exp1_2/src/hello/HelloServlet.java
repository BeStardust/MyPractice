package hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class HelloServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Calendar time=Calendar.getInstance();
		int year=time.get(Calendar.YEAR);
		int month=time.get(Calendar.MONTH)+1;
		int day=time.get(Calendar.DATE);
		String timeString="��ã�������"+year+"��"+month+"��"+day+"�գ�";
		System.out.println(timeString);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.println(timeString);
		out.println("<HR>");
		out.println("���ڴ˴����ԣ�");
		out.println("");
		out.println("<form action=\"HistoricalMessage\" method=\"post\">");
		out.println("<textarea name=\"message\" style=\"width:500px;height:300px\">");
		out.println("</textarea>");
		out.println("<br><br><input type=\"submit\" value=\"�ύ\">");
		out.println("</from>");
		out.println("<form action=\"HistoricalMessage\" method=\"get\">");
		out.println("<br><br><input type=\"submit\" value=\"�鿴��ʷ����\">");
		out.println("</from>");
//		out.println("<HR><a href=\"HistoricalMessage\">�鿴��ʷ����</a>");
		out.println("</BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
