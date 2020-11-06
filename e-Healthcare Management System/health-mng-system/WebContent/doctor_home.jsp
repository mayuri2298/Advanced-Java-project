<%@page import="com.cdac.dto.Doctor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	Doctor d = (Doctor)session.getAttribute("doctor");
	if(d != null && d.getDoctorId()>0){
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<h2 style="align-content: center;font-family:cursive; font-size: 30px;color: green;">CDAC Clinic</h2>
	<table align="center">
		<tr>Welcome <%=((Doctor)session.getAttribute("doctor")).getDoctorName() %></tr>
		<tr>
			<td><a href="patient_add_form.htm">Add Patient</a></td>
			<td><a href="patient_list.htm">Patient List</a></td>
		</tr>
		<tr>
			<td><a href="logout.htm">Logout</a></td>
		</tr>
	</table>
</body>
</html>
<%}else{
	response.sendRedirect("index");
}%>