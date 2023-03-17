<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Student</title>
</head>
<body>
	<form action="UpdateStudent" method="post">
		
		Id(Can't Edit):<input type="text" value="${student.id}" name="id" readonly="true"/> <br/>
		Firstname: <input type="text" value="${student.first_name}" name="firstname"/><br/>
		Lastname: <input type="text" value="${student.last_name}" name="lastname"/><br/>
		Email: <input type="text" value="${student.email}" name="email"/> <br/>
		<input type="submit" value="Update"/>

	</form>
</body>
</html>
