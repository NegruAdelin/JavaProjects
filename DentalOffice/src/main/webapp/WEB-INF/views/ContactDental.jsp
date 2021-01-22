<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
		<title>Contact Dentist</title>
		<style><%@include file="css/style.css"%></style>
	</head>
	
	<body>
		<%@include file="NavbarDental.jsp" %>
		
		<div class="bodyContent">
			<h1>Contact</h1>
			<div class="tableContent">
			<table id="customers">
				<tr>
					<th>Name</th>
					<th>Phone</th>
					<th>Email</th>
					<th>Address</th>
				</tr>
				<tr>
					<td>${dental.getName()}</td>
					<td>${dental.getPhone()}</td>
					<td>${dental.getEmail()}<</td>
					<td>${dental.getAddress()}</td>
				</tr>
			</table>
			<a href="/ResetPasswordDental?id=${id}">Reset Password</a>
			<a href="/EditDataDental?id=${id}">Edit Dentist</a>
			</div>
			
		</div>
	</body>
</html>