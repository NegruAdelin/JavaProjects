<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Sign-up</title>
	<style><%@include file="css/style.css"%></style>
	</head>
	<body>
		<%@include file="NavbarLogin.jsp" %>
		<div class="bodyContent">
			<h1>Create User Account</h1>
			<div class="loginContent">
				
				<form action="http://localhost:8080/Signup" method="post">
					<label for="name">Name</label>
					<input type="text" name="name">
					
					<label for="phone">Phone</label>
					<input type="number" name="phone" >
					
					<label for="email">Email</label>
					<input type="email" name="email">
					
					<label for="password">Password</label>
					<input type="password" name="password">
					<input type="submit" value="Submit">
				</form>
			</div>
		</div>
	</body>
</html>