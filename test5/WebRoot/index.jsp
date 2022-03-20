
<%@ page language="java" errorPage="error.jsp" contentType="text/html;charset=GB2312"%>
<%
	int dividend=0;
	int divisor=0;
	int result=0;
	try{
		result=dividend/divisor;
	}
	catch(ArithmeticException zz){
		throw new ArithmeticException("除数不能为零");
	}
%>