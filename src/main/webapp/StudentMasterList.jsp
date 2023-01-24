<%@page import="com.simpli.p1.Data"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OMS-Student Master List</title>
</head>
<body>
	<div class="container" align="center">

		<div class="vertical-center">
			<h2>Learner Academy-Online Management System - Update Master List</h2>
			<form action="UpdateStudentMasterList" method="post">
				 
				Enter Student:
				<select name = "student">
					<option value = " "> </option>
					<%
					
					Data data = new Data();
					while(data.getRsStudent().next()==true){
					String name = data.getRsStudent().getString(1);
					%>
					<option><%out.print(name); %></option>
					<%} %>
					
				</select>
				<br><br>
				
				Enter Class:
				<select name = "clas">
					<option value = " "> </option>
					<%
					while(data.getRsClass().next()==true){
					String name = data.getRsClass().getString(1);
					
					%>
					<option><%out.print(name); %></option>
					<%} %>
					
				</select>
				<br><br>  
				
				
			 <input type="submit">
			 
			 <br><br>Note: Duplicate value for student will not be accepted, it will update the current class of that student.
			</form>
		</div>
	</div>
</body>
</html>