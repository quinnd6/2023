<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title><c:out value="${title }"> Home Page</c:out></title>
</head>
<body>
	<h1>This is my Spring MVC Project</h1><br>
 	<a href="./employeeReport">Employee Report</a><br>
 	<a href="./studentReport">Student Report</a>
</body>
</html>