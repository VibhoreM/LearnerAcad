<%@page import="com.simpli.p1.Data"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OMS-Master List</title>
</head>
<body>
	<div class="container" align="center">

		<div class="vertical-center">
			<h2>Learner Academy-Online Management System - Update Master List</h2>
			<form action="UpdateMasterList" method="post">
				 
				Enter Subject:
				<select name = "subject">
					<option value = " "> </option>
					<%
					
					Data data = new Data();
					while(data.getRsSubject().next()==true){
					String name = data.getRsSubject().getString(1);
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
				
				Enter Teacher:
				<select name = "teacher">
					<option value = " "> </option>
					<%
					while(data.getRsTeacher().next()==true){
					String name = data.getRsTeacher().getString(1);
					%>
					<option><%out.print(name); %></option>
					<%}
					data.pstmt.close();
					data.con.close();%>
					
				</select>
				<br><br>  
				
			 <input type="submit">
			</form>
		</div>
	</div>
</body>
</html>