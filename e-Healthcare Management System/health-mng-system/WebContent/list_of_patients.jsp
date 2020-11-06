<%@page import="com.cdac.dto.Doctor"%>
<%@page import="com.cdac.dto.Patient"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% Doctor d =(Doctor)session.getAttribute("doctor");
	if(d != null && d.getDoctorId()>0){
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Patients</title>
</head>
<body>
	<table align="center" >
		<% 
		List<Patient> plist = (List<Patient>)request.getAttribute("patientList");
		for(Patient p : plist){
		%>
		<tr>
			<td>
				<%=p.getPatientName()%>
			</td>
			<td>
				<%=p.getPatientAge()%>
			</td>
			<td>
				<%=p.getMobNo()%>
			</td>
			<td>
				<%=p.getCity()%>
			</td>
			<td>
				<%=p.getState()%>
			</td>
			<td>
				<%=p.getPatientWeight()%>
			</td>
			<td>
				<%=p.getBloodGrp()%>
			</td>
			<td>
				<%=p.getDisease()%>
			</td>
			<td>
				<%=p.getSymptoms()%>
			</td>
			<td>
				<%=p.getMedicine()%>
			</td>
			<td>
				<%=p.getComments()%>
			</td>
			<td>
				<a href="generate_report.htm?patientId=<%=p.getPatientId()%>">Generate Report</a>
			</td>
			<td>
				<a href="patient_delete.htm?patientId=<%=p.getPatientId()%>">Delete</a>
			</td>
			<td>
				<a href="patient_update_form.htm?patientId=<%=p.getPatientId()%>">Update</a>
			</td>
		</tr>
		<% } %>
		<tr>
			<td>
				<a href="doctor_home.jsp" >Back</a>
			</td>
			<td>
				<a href="logout.htm" >Logout</a>
			</td>
		</tr>
	</table>
</body>
</html>

<%}else{
	response.sendRedirect("index.jsp");
}%>