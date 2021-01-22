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
		<%@include file="NavbarLogin.jsp" %>
		<div class="bodyContent">
			<h1>LogIn with Dentist Account</h1>
			<div class="loginContent">
				<form action="http://localhost:8080/LoginDental" method="post">
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