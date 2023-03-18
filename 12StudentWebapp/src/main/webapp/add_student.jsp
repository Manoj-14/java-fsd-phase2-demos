<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
</head>
<body>
	<h2>Add Student</h2>
	<form action="addStudent" method="post">
		Firstname: <input type="text" name="firstname"/><br/>
		Lastname: <input type="text" name="lastname"/><br/>
		Email: <input type="email" name="email"/> <br/>
		<input type="submit" value="Add"/>
	</form>
	<a href="index.html">Home</a>
</body>
</html>