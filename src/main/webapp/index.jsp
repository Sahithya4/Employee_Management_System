<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
<style type="text/css" align="center">
body {background-color: powderblue;}
td{
padding:10px;
border:none;
}
#f2{
width:400px;
height:150px;
}
h1{ color:red}
</style>

</head>
<script type="text/javascript">
	function msg() {
		if (document.getElementById("id").value.length == 0) {
			alert("please enter name!!");
			return false;
		}
		if (document.getElementById("password").value.length == 0) {
			alert("please enter password!!");
			return false;
		}

	}
</script>
<center><body>

<h1 align="center">Employee Management System</h1>
<form method="get" action="Servlet" onsubmit="return msg()" >
<fieldset id="f2">
<table align="center">

<tr>
<td>Name:</td>
<td><input type="text" size=25 name="name" id="id"></td>
</tr>

<tr>
<td>Password:</td>
<td><input type="password" size=25 name="password" id="password"></td>
</tr>

<tr>
<td><input type="submit" value="Submit"></td>
</tr>

</table>
</fieldset>
</form>
</body>
</html>