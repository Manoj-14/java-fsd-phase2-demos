<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	int num1 = Integer.parseInt(request.getParameter("number1"));
	int num2 = Integer.parseInt(request.getParameter("number1"));
	int res = num1 + num2;
	%>
	<h3>
		Sum of numbers is :
		<%=res%>
	</h3>
</body>
</html>