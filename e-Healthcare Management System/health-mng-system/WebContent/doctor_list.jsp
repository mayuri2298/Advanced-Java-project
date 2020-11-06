<%@page import="java.util.List"%>
<%@page import="com.cdac.dto.Doctor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Doctors</title>
</head>
<body>
	<table align="center" >
		<% 
		List<Doctor> list = (List<Doctor>)request.getAttribute("doctorList");
		for(Doctor d : list){
		%>
		<tr>
			<td>
				<%=d.getDoctorName()%>
			</td>
			<td>
				<%=d.getDoctorSpcl()%>
			</td>
			<td>
				<%=d.getMobNo()%>
			</td>
			<td>
				<a href="doctor_delete.htm?doctorId=<%=d.getDoctorId()%>">Delete</a>
			</td>
			<td>
				<a href="doctor_update_form.htm?doctorId=<%=d.getDoctorId()%>">Update</a>
			</td>
		</tr>
		<% } %>
		<tr>
			<td>
				<a href="admin_home.jsp" >Back</a>
			</td>
			<td>
				
			</td>
		</tr>
	</table>
</body>
</html>