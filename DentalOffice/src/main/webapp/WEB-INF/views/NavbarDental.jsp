<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<div class="navbar">
	<ul>
	  <li><a class="active" href="http://localhost:8080/HomeDental?id=${id}">Home</a></li>
	  <li><a href="http://localhost:8080/ContactDental?id=${id}">Contact</a></li>
	  <li><a href="http://localhost:8080/UsersForAppointment?id=${id}">Create Appointment</a></li>
	  <li><a href="http://localhost:8080/LogoutDental?id=${id}">Log out</a></li>
	</ul>
</div>
