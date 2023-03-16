<%@ page import="com.demo.tagDemo.Student,java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
List<Student> students = new ArrayList<>();
students.add(new Student("Mary", "Jones"));
students.add(new Student("Max", "Jhonson"));
students.add(new Student("Eric", "Miller"));
pageContext.setAttribute("myStudents", students);
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Students</title>
</head>
<body>
	<h2>Students list</h2>
	<table border="1" style="border-collapse:collapse">
		<tr>
			<th>FirstName</th>
			<th>LastName</th>
		</tr>
		<c:forEach var="student" items="${myStudents}">
			<tr>
				<th>${student.getFirstname()}</th>
				<th>${student.getLastname()}</th>
			</tr>
		</c:forEach>
	</table>
</body>
</html>