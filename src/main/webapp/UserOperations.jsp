<%@ page import="com.bank.entity.*" language="java" contentType="text/html; charset=ISO-8859-1"
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
<%
session=request.getSession();
String name=(String)session.getAttribute("name"); System.out.println(name);%>
<h3 id="an"><a href="UserServlet?varname=applyleave">Apply for Leave</a></h3>
</body>
</html>