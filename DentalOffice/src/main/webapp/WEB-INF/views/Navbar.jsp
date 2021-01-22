<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<div class="navbar">
	<ul>
	  <li><a class="active" href="http://localhost:8080/Home?id=${id}">Home</a></li>
	  <li><a href="http://localhost:8080/Appointment?id=${id}">Appointment</a></li>
	  <li><a href="http://localhost:8080/Contact?id=${id}">Contact</a></li>
	  <li><a href="http://localhost:8080/Logout?id=${id}">Log out</a></li>
	</ul>
</div>
