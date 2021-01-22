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
		<%@include file="Navbar.jsp" %>
		<div class="bodyContent">
			<h1>Home</h1>
			<div class="tableContent">
				<table id="customers">
					<tr>
						<th>Name</th>
						<th>Phone</th>
						<th>Email</th>
						<th>Address</th>
						<th>Appointment</th>
					</tr>
					<c:forEach items="${DentalOffice}" var="dentalOffice">
						<tr>
							<td>${dentalOffice.getName()}</td>
							<td>${dentalOffice.getPhone()}</td>
							<td>${dentalOffice.getEmail()}</td>
							<td>${dentalOffice.getAddress()}</td>
							<td class="buttonTable"><a href="http://localhost:8080/CreateAppointment?id_user=${id}&id_dental=${dentalOffice.getId()}">Appoint</a>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</body>
</html>