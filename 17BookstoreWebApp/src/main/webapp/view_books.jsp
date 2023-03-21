<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books list</title>
</head>
<body>
	<h2>Book</h2>
	<table border="1" style="border-collapse: collapse">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>ISBN</th>
			<th>Price</th>
		</tr>
		<c:forEach var="book" items="${bookDet}">
			<tr>
				<td>${book.id}</td>
				<td>${book.name}</td>
				<td>${book.isbn}</td>
				<td>${book.price}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="index.html">Home</a>
</body>
</html>