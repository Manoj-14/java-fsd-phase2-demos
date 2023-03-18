<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Students</title>
</head>
<body>
	<h2>Students list</h2>
	<table border="1" style="border-collapse: collapse">
		<tr>
			<th>Id</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Email</th>
		</tr>
		<c:forEach var="user" items="${students}">
			<tr>
				<td><a href="UpdateStudent?studentId=${user.id}">${user.id}</a></td>
				<td>${user.first_name}</td>
				<td>${user.last_name}</td>
				<td>${user.email}</td>
				<td><a href="DeleteStudent?studentId=${user.id}" > Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="index.html">Home</a>
</body>
</html>