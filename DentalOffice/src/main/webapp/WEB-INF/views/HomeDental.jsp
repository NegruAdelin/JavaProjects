<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
		<title>DentalOffice</title>
		<style><%@include file="css/style.css"%></style>
	</head>
	<body>
		<%@include file="NavbarDental.jsp" %>
		<div class="bodyContent">
			<h1>Dentist Home</h1>
			<div class="tableContent">
			<table id="customers">
				<tr>
					<th>Name</th>
					<th>Phone</th>
					<th>Email</th>
					<th>Delete Appointment</th>
				</tr>
				<c:forEach items="${appointment}" var="appointment">
					<tr>
						<td>${appointment.getUser().getName()}</td>
						<td>${appointment.getUser().getPhone()}</td>
						<td>${appointment.getUser().getEmail()}</td>
						<td class="buttonTable"><a href="/DeleteDental?id_dental=${id}&id_appointment=${appointment.getId()}">Delete</a>
					</tr>
				</c:forEach>
			</table>
			</div>
		</div>
	</body>
</html>