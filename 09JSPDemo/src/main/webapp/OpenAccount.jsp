<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Open Account</title>
</head>
<body>
	<%!
	
	Connection con;
	PreparedStatement ps;
	
	public void jspInit(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/newdb","root","root");
			ps = con.prepareStatement("insert into account values(?,?,?,?)");
		}catch(SQLException se){
			se.printStackTrace();
		}catch( ClassNotFoundException cne){
			cne.printStackTrace();
		}
	}
	
	public void jspDestroy(){
		try{
			ps.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	%>
	
	<%
		int accNo = Integer.parseInt(request.getParameter("accNo"));
		int balance = Integer.parseInt(request.getParameter("balance"));
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		
		ps.setInt(1, accNo);
		ps.setString(2, lastName);
		ps.setString(3, firstName);
		ps.setInt(4, balance);
		
		int res = ps.executeUpdate();
		
		if(res > 0) out.println("Account added");
		else out.println("Error in adding account");
	
	%>
	
	<%@ include file="OpenAccount.html" %>
	
</body>
</html>