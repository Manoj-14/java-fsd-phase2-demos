<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Date Time</title>
</head>
<body>

	Time on the server is
	<%=new java.util.Date()%>

	<br />
	<br />

	<%
	Date myDate = new Date();
	%>
	My date =
	<%=myDate%>

	<c:set var="date" value="<%=new Date()%>" />
	<br />
	<br />
	 My Date using taglib is: ${date} 
	

</body>
</html>