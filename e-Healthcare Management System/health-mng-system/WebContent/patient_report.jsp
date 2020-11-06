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
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Report</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
	<%
		Patient p = (Patient)request.getAttribute("patient");
	%>
		
	<div class="container-fluid">
        <div class="row bg-info justify-content-between align-items-center sticky-top" style="height: 60px;">
            <div class="col-6" style="color: white;">Healthcare Center</div>

            <div class="col-3 d-flex justify-content-end" >
            	<a href = "doctor_home.jsp">Home</a>
            	<a href = "logout.htm" style="color: white;">Logout</a>
            </div>
        </div>

        <div class="row mt-1 justify-content-center">

            <div class="col-12 col-md-6 d-flex justify-content-center align-items-center rounded bg-white border">
                <table align="center">
                <tr>
                	<td>
                		<%=((Doctor)session.getAttribute("doctor")).getDoctorName()%><br>
                		Cdac clinic,Juhu Mumbai 400049<br>
                	</td>
                </tr>
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
                </table>

            </div>
		
        </div>


    </div>
</body>
</html>
<% }else{
	response.sendRedirect("index.jsp");
}%>