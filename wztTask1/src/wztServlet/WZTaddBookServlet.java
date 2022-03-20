package wztServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class WZTaddBookServlet extends HttpServlet {

	public WZTaddBookServlet() {
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

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		int flag=0;
		boolean BookName=true;
		boolean Author=true;
		boolean Publisher=true;
		String wztBookName=request.getParameter("wztBookName");
//		wztBookName=new String(wztBookName.getBytes("iso-8859-1"),"UTF-8");
		String wztAuthor=request.getParameter("wztAuthor");
		
		String wztPublisher=request.getParameter("wztPublisher");
		if(wztBookName==null||wztBookName.equals("")){
			BookName=false;
		}
		if(wztAuthor==null||wztAuthor.equals("")){
			Author=false;
		}
		if(wztPublisher==null||wztPublisher.equals("")){
			Publisher=false;
		}
		if(BookName==false||Author==false||Publisher==false){
			if(BookName==false){
				out.println("书名");
				System.out.print("书名");
				flag=1;
			}
			if(Author==false){
				if (flag==1) {
					out.println(",");
					System.out.print(",");
				}
				out.println("作者");
				System.out.print("作者");
				flag=1;
			}
			if(Publisher==false){
				if (flag==1) {
					out.println(",");
					System.out.print(",");
				}
				out.println("出版社");
				System.out.print("出版社");
			}
	
			out.println("为空！");
			System.out.print("为空！");
			String WZTaddBook="../WZTaddBook.html";
			response.setHeader("Refresh", "1;URL="+WZTaddBook);
		
		}
		else{
			out.println("书名：");
			out.println(wztBookName);
			out.println("<br>");
			out.println("作者：");
			out.println(wztAuthor);
			out.println("<br>");
			out.println("出版社：");
			out.println(wztPublisher);
			out.println("<br>");
		}

		out.close();
		
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
