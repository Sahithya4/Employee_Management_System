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
		if (document.getElementById("startdate").value.length == 0) {
			alert("please enter startdate!!");
			return false;
		}
		if (document.getElementById("enddate").value.length == 0) {
			alert("please enter enddate!!");
			return false;
		}
		if (document.getElementById("reason").value.length == 0) {
			alert("please enter reason!!");
			return false;
		}

	}
</script>
<style>
body {background-image: url(img1.jpg);background-repeat: no-repeat;}
</style>
<body>
<form method="post" action="UserServlet?varname=apply" onsubmit="return msg()">
		<table align="center">
			<tr>
				<td>Start date:</td>
				<td><input type="text" size=25 placeholder="yyyy-mm-dd" name="sd" id="startdate"></td>
			</tr>
			<tr>
				<td>End date:</td>
				<td><input type="text" size=25 placeholder="yyyy-mm-dd" name="ed" id="enddate"></td>
			</tr>
			<tr>
				<td>Reason:</td>
				<td><input type="text" size=45 name="reason" id="reason"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>