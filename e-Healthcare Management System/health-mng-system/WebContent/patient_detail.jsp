<%@page import="com.cdac.dto.Patient"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient details</title>
</head>
<body>
	<spr:form action="patient_generate_report.htm" method="post" commandName="patient" >
	<table align="center" >
		
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
				<a href="index.jsp" >Back</a>
			</td>
			<td>
				<input type="submit"  value="Report" >
			</td>
		</tr>
	</table>
	</spr:form>
</body>
</html>