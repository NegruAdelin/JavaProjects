<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
		<title>Appointment</title>
		<style><%@include file="css/style.css"%></style>
	</head>
	
	<body>
		<%@include file="Navbar.jsp" %>
		
		<div class="bodyContent">
			<h1>Appointment</h1>
			<div class="tableContent">
			<table id="customers">
				<tr>
					<th>Name</th>
					<th>Phone</th>
					<th>Email</th>
					<th>Address</th>
					<th>Date</th>
				</tr>
				<c:forEach items="${appointment}" var="appointment">
					<tr>
						<td>${appointment.getDental_office().getName()}</td>
						<td>${appointment.getDental_office().getPhone()}</td>
						<td>${appointment.getDental_office().getEmail()}</td>
						<td>${appointment.getDental_office().getAddress()}</td>
						<td>${appointment.getDate()}</td>
					</tr>
				</c:forEach>
			</table>
			</div>
		</div>
	</body>
</html>