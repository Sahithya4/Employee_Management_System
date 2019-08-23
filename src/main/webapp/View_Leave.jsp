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
	<h1>List of Leaves</h1>
	<br>
	<br>
	<form>
		<table border="1" align="center">
			<thead>
				<tr>
				    <th>Employee id</th>
				    <th>Name</th>
					<th>Start date</th>
					<th>End date</th>
					<th>Reason</th>
					<th>Status</th>
				</tr>
			</thead>
			<%
			ArrayList<String> list = (ArrayList<String>) request.getAttribute("leave");//list.readEntity(ArrayList.class);
	           // out.print(list1);
	           if(list.isEmpty()){}
	           else{
				Iterator<String> it=list.iterator();
				while(it.hasNext()){
					//it.next();
					String id=it.next();
					String name=it.next();
					String startdate=it.next();
					String enddate=it.next();
					String reason=it.next();
					String status=it.next();

				%>
				<tr>
				    <td><%out.print(id); %></td>
				    <td><%out.print(name); %></td>
					<td><%out.print(startdate); %></td>
					<td><%out.print(enddate); %></td>
					<td><%out.print(reason); %></td>
					<td><%out.print(status); %></td>
					<td><a href="UserServlet?varname=accept&id=<%=id%>">Accept</a></td>
					<td><a href="UserServlet?varname=reject&id=<%=id%>">Reject</a></td>
				</tr>
				<%
			}
			}%>


		</table>
	</form>
	
</body>
</html>