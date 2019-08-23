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
	<h1>List of Employees Reporting To Specific Manager</h1>
	<br>
	<br>
	<form>
		<table border="1" align="center">
			<thead>
				<tr>
					<th>Department name</th>
				</tr>
			</thead>
			<%
			ArrayList<String> list = (ArrayList<String>) request.getAttribute("manager");//list.readEntity(ArrayList.class);
	            //out.print(list);

				for(String e: list){
				%>
				<tr>
					<td><%= e%></td>
				</tr>
				<%
			}
			%>


		</table>
	</form>
</body>
</html>