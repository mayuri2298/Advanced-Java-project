<%@page import="com.cdac.dto.Doctor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %>
<% Doctor d =(Doctor)session.getAttribute("doctor");
	if(d != null && d.getDoctorId()>0){
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient Report</title>
</head>
<body>
	<h2>Doctor Name : <%=((Doctor)session.getAttribute("doctor")).getDoctorName() %></h2>
	<spr:form action="patient_add.htm" method="post" commandName="patient" >
	
	<table align="center" >
		<tr>
			<td>
				Patient Name:
			</td>
			<td>
				<spr:input path="patientName"/>
			</td>
		</tr>
		<tr>
			<td>
				Age:
			</td>
			<td>
				<spr:input path="patientAge"/>
			</td>
		</tr>
		<tr>
			<td>
				Mobile No:
			</td>
			<td>
				<spr:input path="mobNo"/>
			</td>
		</tr>
		<tr>
			<td>
				City:
			</td>
			<td>
				<spr:input path="city"/>
			</td>
		</tr>
		<tr>
			<td>
				State:
			</td>
			<td>
				<spr:input path="state"/>
			</td>
		</tr>
		<tr>
			<td>
				Weight:
			</td>
			<td>
				<spr:input path="patientWeight"/>
			</td>
		</tr>
		<tr>
			<td>
				Blood Group:
			</td>
			<td>
				<spr:input path="bloodGrp"/>
			</td>
		</tr>
		<tr>
			<td>
				Disease:
			</td>
			<td>
				<spr:input path="disease"/>
			</td>
		</tr>
		<tr>
			<td>
				Symptoms:
			</td>
			<td>
				<spr:input path="symptoms"/>
			</td>
		</tr>
		<tr>
			<td>
				Medicine:
			</td>
			<td>
				<spr:input path="medicine"/>
			</td>
		</tr>
		<tr>
			<td>
				Comments:
			</td>
			<td>
				<spr:input path="comments"/>
			</td>
		</tr>
		
		
		<tr>
			<td>
				<a href="doctor_home.jsp" >Back</a>
			</td>
			<td>
				<input type="submit"  value="Generate Report" >
			</td>
		</tr>
	</table>
	</spr:form>
</body>
</html>
<% }else{
	response.sendRedirect("index.jsp");
}%>