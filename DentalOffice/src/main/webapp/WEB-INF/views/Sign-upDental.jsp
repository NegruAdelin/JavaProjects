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
			<h1>Create Dentist Account</h1>
			<div class="loginContent">
				
				<form action="/SignupDental" method="post">
				
					<label for="name">Name</label>
					<input type="text" name="name">
					
					<label for="phone">Phone</label>
					<input type="number" name="phone">
					
					<label for="email">Email</label>
					<input type="email" name="email">
					
					<label for="password">Password</label>
					<input type="password" name="password">
					
					<label for="address">Address</label>
					<input type="text" name="address">
					<input type="submit" value="Submit">
				</form>
			</div>
		</div>
	</body>
</html>