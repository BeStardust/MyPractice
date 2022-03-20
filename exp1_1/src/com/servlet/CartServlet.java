package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@SuppressWarnings("serial")
public class CartServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(true);

		HashMap cart = (HashMap) session.getAttribute("cart");

	    if (cart == null) {
	      cart = new HashMap();
	      cart.put("apple","0");
	      cart.put("banana","0");
	      cart.put("grape","0");
	      session.setAttribute("cart", cart);
	    } 
	    res.setContentType("text/html;charset=gb2312");
	    PrintWriter out = res.getWriter();
	   

	    
	    req.setCharacterEncoding("gb2312");
	    String apple_amount=req.getParameter("apple_amount");
	    String banana_amount=req.getParameter("banana_amount");
	    String grape_amount=req.getParameter("grape_amount");
	    String appleAmount=(String)cart.get("apple");
	    String bananaAmount=(String)cart.get("banana");
	    String grapeAmount=(String)cart.get("grape");
	   
	    //int te=Integer.parseInt(appleAmount,10);
	    //int te1=Integer.getInteger(apple_amount).intValue();
	    int new_apple_amount =Integer.parseInt(appleAmount,10)+Integer.parseInt(apple_amount,10);
	    int new_banana_amount =Integer.parseInt(bananaAmount,10)+Integer.parseInt(banana_amount,10);
	    int new_grape_amount =Integer.parseInt(grapeAmount,10)+Integer.parseInt(grape_amount,10);
	    cart.put("apple",String.valueOf(new_apple_amount));
	    cart.put("banana",String.valueOf(new_banana_amount));
	    cart.put("grape",String.valueOf(new_grape_amount));
	    
	    // Print Current Contents of Cart
	    
	    out.println("<HTML><HEAD><TITLE>");
	    out.println("购物车内容");
	    out.println("</TITLE></HEAD>");
	    out.println("<BODY>");
	    out.println("<H1>你的购物车里有</H1>"+
	    		new_apple_amount+"斤苹果 "+new_banana_amount+"斤香蕉 "
				+new_grape_amount+"斤葡萄");
	    out.println("<HR>");

	    
	    out.print("<HR><p><A HREF=\"");
	    out.print(res.encodeURL("catalog"));
	    out.println("\">回到水果店</A></p>");

	    out.close();

	}
}
