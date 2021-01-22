<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<style><%@include file="css/style.css"%></style>
	</head>
	<body>
		<%@include file="Navbar.jsp" %>
		
		<div class="bodyContent">
			<h1>Edit Data</h1>
			<div class="loginContent">
			<form action="/EditData" method="post">
				<input hidden="true" value="${user.getId()}" name="id">
				<input type="text" name="name" value="${user.getName()}">
				<input type="email" name="email" value="${user.getEmail()}">
				<input name="password" value="${user.getPassword()}" hidden="true">
				<input type="number" name="phone" value="${user.getPhone()}">
				<input type="submit" value="Confirm">
			</form>
			</div>
		</div>
	</body>
</html>