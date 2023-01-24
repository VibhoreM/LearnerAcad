<%@page import="com.simpli.p1.Data"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Class-Report</title>
</head>
<body>
	<div class="container" align="center">

		<div class="vertical-center">
			<h2>Learner Academy-Online Management System - Update Master List</h2>
			<form action="ClassData" method="post">
				 
				Enter Class:
				<select name = "clas">
					<option value = " "> </option>
					<%
					
					Data data = new Data();
					while(data.getRsClass().next()==true){
					String name = data.getRsClass().getString(1);
					%>
					<option><%out.print(name); %></option>
					<%} %>
					
				</select>
				
			 <input type="submit">
			</form>
		</div>
	</div>
</body>
</html>