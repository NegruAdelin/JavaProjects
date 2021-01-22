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
		<h1>Reset User Password</h1>
			<div class="loginContent">
				<div class="loginContent">
				<form action="http://localhost:8080/ResetPassword?id=${id}" method="post">
					<input type="password" name="password" placeholder="Enter the password">
					<input type="submit" value="Submit">
				</form>
				</div>
			</div>
		</div>
	</body>
</html>