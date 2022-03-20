package hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HistoricalMessageServlet extends HttpServlet {
	ArrayList<Object> message=new ArrayList<Object>();

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String messageString = request.getParameter("message");	
		Calendar time =Calendar.getInstance();
		int year=time.get(Calendar.YEAR);
		int month=time.get(Calendar.MONTH)+1;
		int day=time.get(Calendar.DATE);
		int hour=time.get(Calendar.HOUR_OF_DAY);
		int minute=time.get(Calendar.MINUTE);
		int second=time.get(Calendar.SECOND);
		String timeString="留言时间："+year+"年"+month+"月"+day+"日"+" "+hour+":"+minute+":"+second;
		
			if (messageString.length()>0) {
				this.message.add(messageString+"<p align=\"right\">"+timeString+"</p>");
			}
		
	
		if (message!=null) {
			for (int i = message.size()-1; i >=0 ; i--) {
				out.println(message.get(i));
				out.println("<HR>");
			}
			out.println("<p>3秒后自动返回留言板<p>");
			response.setHeader("REFRESH", "3,URL="+"Hello");
		}

		out.flush();
		out.close();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		if (message!=null) {
	
			for (int i = message.size()-1; i >=0 ; i--) {
				if (message.get(i)==null||message.get(i).equals("")) {

				}
				else {
					out.println(message.get(i));out.println("<HR>");
				}
				
			
				
			}
		}
		out.println("<br><HR><br>");
		out.println("<p>3秒后自动返回留言板<p>");
		out.flush();
		out.close();
	}

}
