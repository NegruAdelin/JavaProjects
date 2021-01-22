<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Set Services</title>
		<style><%@include file="css/style.css"%></style>
	</head>
	<body>
		<%@include file="NavbarDental.jsp" %>
		
		<div class="bodyContent">
			<form action="/SetServices?id=${id}" method="post">
				<input  name="operations" placeholder="Enter your services and price" value="${services.getOperations()}">
				<input type="submit" value="Confirm">
			</form>
		</div>
	</body>
</html>