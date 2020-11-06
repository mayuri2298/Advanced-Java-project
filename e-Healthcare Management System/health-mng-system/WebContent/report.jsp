<%@page import="com.cdac.dto.Patient"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% Patient p =((Patient) session.getAttribute("patient")); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient report</title>
<script type="text/javascript"></script>
</head>
<body>
<table align="center">
	<tr><td align="center"><h5>Report of <%=p.getPatientName() %></h5></td>
                </tr>
                    <tr>
                        <td>Patient Name :
                            <%=p.getPatientName() %>
                        </td>
                    </tr>
                    <tr>
                        <td>Mobile No. :
                            <%=p.getMobNo() %>
                        </td>
                    </tr>
                    <tr>
                        <td>City :
                            <%=p.getCity() %>
                        </td>
                    </tr>
                    <tr>
                        <td>State :
                            <%=p.getState() %>
                        </td>
                    </tr>
                    <tr>
                        <td>Patient Age :
                            <%=p.getPatientAge() %>
                        </td>
                    </tr>
                    <tr>
                        <td>Weight :
                            <%=p.getPatientWeight() %>
                        </td>
                    </tr>
                    <tr>
                        <td>Blood Group :
                            <%=p.getBloodGrp()%>
                        </td>
                    </tr>
                    <tr>
                        <td>Disease :
                            <%=p.getDisease() %>
                        </td>
                    </tr>
                    <tr>
                        <td>Symptoms :
                            <%=p.getSymptoms() %>
                        </td>
                    </tr>
                    <tr>
                        <td>Medicine :
                            <%=p.getMedicine()%>
                        </td>
                    </tr>
                    <tr>
                        <td>Comments :
                            <%=p.getComments()%>
                        </td>
                    </tr>
                    <tr>
                        <td>
                        	<button onclick="window.print()">Print</button>
                        </td>
                        <td>
                            <a href="index.jsp">Back</a>
                        </td>
                    </tr>
                    
			</table>
	
</body>
</html>