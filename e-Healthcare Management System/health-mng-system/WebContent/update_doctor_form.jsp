<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Doctor</title>
</head>
<body>
	<spr:form action="update_doctor.htm" method="post" commandName="doctor" >
	<table align="center" >
		<tr>
			<td>
				
			</td>
			<td>
				<spr:hidden path="doctorId"/>
			</td>
		</tr>
		<tr>
			<td>
				Doctor Name:
			</td>
			<td>
				<spr:input path="doctorName"/>
			</td>
		</tr>

		<tr>
			<td>
				Doctor Specialty:
			</td>
			<td>
				<spr:input path="doctorSpcl"/>
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
				<a href="admin_home.jsp" >Back</a>
			</td>
			<td>
				<input type="submit"  value="Update" >
			</td>
		</tr>
	</table>
	</spr:form>
</body>
</html>