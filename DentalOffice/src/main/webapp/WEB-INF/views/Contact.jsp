<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
		<title>Contact</title>
		<style><%@include file="css/style.css"%></style>
	</head>
	
	<body>
		<%@include file="Navbar.jsp" %>
		
		<div class="bodyContent">
			<h1>Contact</h1>
			<div class="tableContent">
			<table id="customers">
				<tr>
					<th>Name</th>
					<th>Phone</th>
					<th>Email</th>
				</tr>
				<tr>
					<td>${user.getName()}</td>
					<td>${user.getPhone()}</td>
					<td>${user.getEmail()}</td>
				</tr>
			</table>
			<a href="/ResetPassword?id=${id}">Reset Password</a>
			<a href="/EditData?id=${id}">Edit</a>
			</div>
			
		</div>
	</body>
</html>