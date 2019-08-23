<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {background-color: rgba(255, 99, 71, 0.4)}
</style>
<body>
<form method="post" action="AdminServlet?varname=listmanager">
		<table align="center">
			<tr>
				<td>Manager name:</td>
				<td><input type="text" size=25 name="manager"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>