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
					<th>Appoint</th>
				</tr>
				<c:forEach items="${user}" var="user">
					<tr>
						<td>${user.getName()}</td>
						<td>${user.getPhone()}</td>
						<td>${user.getEmail()}</td>
						<td class="buttonTable"><a href="http://localhost:8080/CreateAppointment?id_dental=${id}&id_user=${user.getId()}">Appoint</a>
					</tr>
				</c:forEach>
			</table>
			</div>
		</div>
	</body>
</html>