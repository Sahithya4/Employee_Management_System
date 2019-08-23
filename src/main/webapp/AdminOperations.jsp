<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Operations</title>

<style type="text/css">
#an{
align:center;

}
td{
padding:10px;
border:none;
}
#f2{
width:400px;
height:450px;
background-color:lightgrey;
}
body {text-align: center;background-color:lightgrey;}
</style>
</head>
<body>
<h3 id="an"><a href="AdminServlet?varname=add">Add user</a></h3>
<h3 id="an"><a href="AdminServlet?varname=delete">Delete user</a></h3>
<h3 id="an"><a href="AdminServlet?varname=employee">List of employees</a></h3>
<h3 id="an"><a href="AdminServlet?varname=department">List of departments</a></h3>
<h3 id="an"><a href="AdminServlet?varname=manager">List of employees reporting to a specific manager</a></h3>
<h3 id="an"><a href="AdminServlet?varname=pf">Calculating pf for specific employee</a></h3>
<h3 id="an"><a href="AdminServlet?varname=salary">List of employees whose salary ranges from 10000 to 20000</a></h3>
</body>
</html>