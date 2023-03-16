<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Functions</title>
</head>
<body>
	<c:set var="data" value="hello world"></c:set>
	Value of the variable = <b>${data}</b> <br/>
	Length of the variable = <b>${fn:length(data)}</b> <br/>
	UpperCase of the variable = <b>${fn:toUpperCase(data)}</b> <br/> 
</body>
</html>