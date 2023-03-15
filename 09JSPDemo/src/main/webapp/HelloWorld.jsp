<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>First JSP</title>
</head>
<body>
	<h1>Hello from JSP</h1>

	<!--  Directives -> it is used to tell how to translated
		3 types:
		1. </%@ include  %> -> include
		2. </%@ page  %> -> Page
		3. </%@ taglib  %> -> Taglib
	
	 -->
	<!-- </% %> -> Script let  it goes to service method-->
	<!-- </%= %> -> Script expression  -->
	<!-- </%! %> -> Script Declaration for declaration of filed level variables  -->
	<!--
		Some methods are already available in jsp files like:
		-config
		-request
		-response
		-session
		-ServletContext
		-page	
		-pageContext
		-exception
		-out (in scriplet or declaration not in Expression)
	  -->

</body>
</html>