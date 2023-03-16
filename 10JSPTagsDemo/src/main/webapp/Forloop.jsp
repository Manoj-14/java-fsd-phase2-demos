<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>For Each</title>
</head>
<body>
	
	<p>Using Traditional method Java</p>

	<%
		String[] places = {"Shimoga","Mysore","Banglore","Mandya"};
		pageContext.setAttribute("places", places);
		
		for(String place:places) out.println("-->"+place+"<br/>");
	%>
	<p>Using JSP Tags</p>
	
	<c:forEach var="place" items="${places}">
		-->${place} <br/>
	</c:forEach>
	
</body>
</html>