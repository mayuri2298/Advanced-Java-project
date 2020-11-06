<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login as Doctor</title>
</head>
<body>
	<spr:form action="doct_login.htm" method="post" commandName="doctor" >
	<table align="center" >
		<tr>
			<td>
				Doctor Name:
			</td>
			<td>
				<spr:input path="doctorName"/>
				<font color="Green" ><spr:errors path="doctorName" ></spr:errors></font>
			</td>
		</tr>
		<tr>
			<td>
				Password:
			</td>
			<td>
				<spr:password path="doctorPass"/>
				<font color="Green" ><spr:errors path="doctorPass" ></spr:errors></font>
			</td>
		</tr>
		<tr>
			<td>
				<a href="index.jsp" >Back</a>
			</td>
			<td>
				<input type="submit"  value="Login" >
			</td>
		</tr>
		
	</table>
	</spr:form>
</body>
</html>