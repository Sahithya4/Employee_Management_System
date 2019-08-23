<%@ page import="java.sql.*,java.util.*,com.bank.entity.*,com.employee.repository.*,javax.ws.rs.client.*,javax.ws.rs.core.Response,javax.ws.rs.core.MediaType,org.glassfish.jersey.client.ClientConfig"
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of employees</title>
</head>
<style>
body {
	border-style: solid;
	border-width: medium;
	background-color: powderblue;
}

h1 {
	text-align: center;
	color: Tomato
}
</style>
<body>
	<h1>List of Employees</h1>
	<br>
	<br>
	<form>
		<table border="1" align="center">
			<thead>
				<tr>

					<th>Employee id</th>
					<th>Employee name</th>
					<th>Email</th>
					<th>Department name</th>
					<th>Reporting manager</th>
					<th>Salary</th>
				</tr>
			</thead>
			<%
			ArrayList<Employee> list = (ArrayList<Employee>) request.getAttribute("data");//list.readEntity(ArrayList.class);
	           // out.print(list1);

				for(Employee e: list){
				%>
				<tr>

					<td><%= e.getEmployeeid()%></td>
					<td><%= e.getEmployeename() %></td>
					<td><%= e.getEmail()%></td>
					<td><%= e.getDepartmentname()%></td>
					<td><%= e.getReportingmanager()%></td>
					<td><%= e.getSalary()%></td>
				</tr>
				<%
			}
			%>


		</table>
	</form>
	<!--<form method="post" action="AdminServlet?varname=empp">
		<table align="center">
			<tr>
				<td>From :</td>
				<td><input type="text" size=25 name="from"></td>
			</tr>
			<tr>
				<td>to :</td>
				<td><input type="text" size=25 name="to"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>-->
</body>
</html>