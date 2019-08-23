<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function msg() {
		if (document.getElementById("employeename").value.length == 0) {
			alert("please enter employeename!!");
			return false;
		}
		if (document.getElementById("email").value.length == 0) {
			alert("please enter email!!");
			return false;
		}
		if (document.getElementById("departmentname").value.length == 0) {
			alert("please enter departmentname!!");
			return false;
		}
		if (document.getElementById("reportingmanager").value.length == 0) {
			alert("please enter reportingmanager!!");
			return false;
		}
		if (document.getElementById("salary").value.length == 0) {
			alert("please enter salary!!");
			return false;
		}
	}
</script>
<style>
body {background-image: url(img1.jpg);background-repeat: no-repeat;}
</style>
<body>
<form method="post" action="AdminServlet?varname=adddetails" onsubmit="return msg()">
		<table align="center">
			<tr>
				<td>Employee Name:</td>
				<td><input type="text" size=25 name="name" id="employeename"></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" size=25 name="email" id="email"></td>
			</tr>
			<tr>
				<td>Department name:</td>
				<td><input type="text" size=25 name="deptname" id="departmentname"></td>
			</tr>
			<tr>
				<td>Reporting manager:</td>
				<td><input type="text" size=25 name="repmanager" id="reportingmanager"></td>
			</tr>
			<tr>
				<td>Salary:</td>
				<td><input type="text" size=25 name="salary" id="salary">
			</tr>
			<tr>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>