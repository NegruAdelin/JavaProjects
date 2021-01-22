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
		<%@include file="NavbarDental.jsp" %>
		
		<div class="bodyContent">
			<h1>Edit Data</h1>
			<div class="loginContent">
			<form action="/EditDataDental" method="post">
				<input hidden="true" value="${dental.getId()}" name="id">
				<input type="text" name="name" placeholder="Enter name" value="${dental.getName()}">
				<input type="email" placeholder="Enter email" name="email" value="${dental.getEmail()}">
				<input name="password" placeholder="Enter password" value="${dental.getPassword()}" hidden="true">
				<input type="number" name="phone" placeholder="Enter phone" value="${dental.getPhone()}">
				<input type="text" name="address" placeholder="Enter address" value="${dental.getAddress()}">
				<input type="submit" value="Confirm">
			</form>
			</div>
		</div>
	</body>
</html>